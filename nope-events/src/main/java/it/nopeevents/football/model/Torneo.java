package it.nopeevents.football.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Torneo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String nome;

	private String descrizione;

	private Long montepremi;

	private LocalDate dataInizio;

	@ManyToMany
	private List<Squadra> squadrePartecipanti;

	@OneToMany(cascade = {CascadeType.PERSIST})
	private List<Partita> partite;

	@OneToMany(cascade = {CascadeType.PERSIST})
	private List<PosizioneTorneo> classifica;

	public Torneo(String nome, List<Squadra> partecipanti) {
		this.nome = nome;
		this.setSquadrePartecipanti(partecipanti);
		this.partite = new ArrayList<>();
		this.classifica = new ArrayList<>();
		this.setCalendario();
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

//		for(Squadra s: partecipanti)
//			s.addTorneo(this);
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

//	private void addPartita(Partita p) {
//		this.getPartite().add(p);
//	}

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
		
	}	
}
