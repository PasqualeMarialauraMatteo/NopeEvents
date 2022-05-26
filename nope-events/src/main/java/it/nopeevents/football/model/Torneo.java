package it.nopeevents.football.model;

import java.time.LocalDate;
import java.util.List;

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
	
	@ManyToMany(mappedBy = "tornei")
	private List<Squadra> squadrePartecipanti;
	
	@OneToMany
	private List<Partita> partite;
	
	@OneToMany
	private List<PosizioneTorneo> classifica;

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

	public void setSquadrePartecipanti(List<Squadra> squadrePartecipanti) {
		this.squadrePartecipanti = squadrePartecipanti;
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
}
