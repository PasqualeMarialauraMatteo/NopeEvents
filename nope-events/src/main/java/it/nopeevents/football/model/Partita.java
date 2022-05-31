package it.nopeevents.football.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Partita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Integer giornata;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	private Torneo torneo;
	
	@OneToOne
	private Squadra casa;
	
	@OneToOne
	private Squadra ospite;

	private boolean giocata;
	
	private Long golCasa;

	private Long golTrasferta;
	
	public Partita(Integer giornata, Torneo torneo, Squadra casa, Squadra ospite) {
		this.giornata = giornata;
		this.torneo = torneo;
		this.casa = casa;
		this.ospite = ospite;
		this.giocata = false;
	}
	
	public Partita() {
		this(null,null,null,null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getGiornata() {
		return giornata;
	}

	public void setGiornata(Integer gionata) {
		this.giornata = gionata;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public Squadra getCasa() {
		return casa;
	}

	public void setCasa(Squadra casa) {
		this.casa = casa;
	}

	public Squadra getOspite() {
		return ospite;
	}

	public void setOspite(Squadra ospite) {
		this.ospite = ospite;
	}

	public boolean isGiocata() {
		return giocata;
	}

	public void setGiocata() {
		this.giocata = true;
				
		this.getTorneo().registerPartita(this.getCasa(),this.getOspite(), this.getGolCasa(), this.getGolTrasferta());
	}

	public Long getGolCasa() {
		return golCasa;
	}

	public void setGolCasa(Long golCasa) {
		this.golCasa = golCasa;
	}

	public Long getGolTrasferta() {
		return golTrasferta;
	}

	public void setGolTrasferta(Long golTrasferta) {
		this.golTrasferta = golTrasferta;
	}
}
