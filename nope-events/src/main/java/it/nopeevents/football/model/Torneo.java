package it.nopeevents.football.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Torneo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String nome;

	private String descrizione;

	private Long montepremi;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInizio;

	@ManyToMany
	private List<Squadra> squadrePartecipanti;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Partita> partite;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<PosizioneTorneo> classifica;

	public Torneo(String nome, List<Squadra> partecipanti) {
		this.nome = nome;
		this.setSquadrePartecipanti(partecipanti);
		this.partite = new ArrayList<>();
		this.classifica = new ArrayList<>();
		this.setCalendario();
	}

	public Torneo() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getMontepremi() {
		return montepremi;
	}

	public void setMontepremi(Long montepremi) {
		this.montepremi = montepremi;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public List<Squadra> getSquadrePartecipanti() {
		return squadrePartecipanti;
	}

	public void setSquadrePartecipanti(List<Squadra> partecipanti) {
		this.squadrePartecipanti = partecipanti;
	}

	public List<Partita> getPartite() {
		return partite;
	}

	public void setPartite(List<Partita> partite) {
		this.partite = partite;
	}

	public List<PosizioneTorneo> getClassifica() {
		return classifica;
	}

	public void setClassifica(List<PosizioneTorneo> classifica) {
		this.classifica = classifica;
	}

	private void setCalendario() {
		this.initializeClassifica();
		this.generateCalendario();
	}

	private void initializeClassifica() {
		for(Squadra s: this.getSquadrePartecipanti()) {
			this.getClassifica().add(new PosizioneTorneo(this, s));
		}
	}

	private void generateCalendario() {
		List<Squadra> squadre = new ArrayList<>();
		squadre.addAll(this.getSquadrePartecipanti());
		Collections.shuffle(squadre, new Random());
		
		int numeroSquadre = squadre.size();

		for(int giornata = 1; giornata < numeroSquadre; giornata++) {
			this.generateOneRound(giornata,squadre);
			
			squadre.add(1,squadre.get(numeroSquadre-1));
			squadre.remove(numeroSquadre);
		}
	}
	
	private void generateOneRound(int giornata, List<Squadra> squadre) {
		int j, middle = squadre.size()/2;
		int distanzaRitorno = squadre.size() - 1;
		
		List<Squadra> l1 = new ArrayList<>();
		for(j = 0; j < middle; j++) l1.add(squadre.get(j));
		
		List<Squadra> l2 = new ArrayList<>();
		for(j = squadre.size() - 1; j >= middle; j--) l2.add(squadre.get(j));
		
		for(j = 0; j < l1.size(); j++) {
			Squadra s1, s2;
			
			if(giornata%2 == 1) {
				s1 = l1.get(j);
				s2 = l2.get(j);
			}
			else {
				s1 = l2.get(j);
				s2 = l1.get(j);
			} 
			
			this.addPartita(giornata, s1, s2);
			this.addPartita(giornata+distanzaRitorno, s2, s1);
		}
	}

	private void addPartita(int giornata, Squadra s1, Squadra s2) {
		this.getPartite().add(new Partita(giornata,this,s1,s2));		
	}

	public void registerPartita(Squadra casa, Squadra ospite, Long golCasa, Long golTrasferta) {
		PosizioneTorneo posCasa = this.findPosizioneSquadra(casa);
		PosizioneTorneo posOspt = this.findPosizioneSquadra(ospite);
		
		posCasa.registerEsito(golCasa,golTrasferta);
		posOspt.registerEsito(golTrasferta,golCasa);
	}
	
	private PosizioneTorneo findPosizioneSquadra(Squadra s) {
		for(PosizioneTorneo pt: this.getClassifica()) {
			if(pt.getSquadra().equals(s)) return pt;
		}
		
		return null;
	}
}
