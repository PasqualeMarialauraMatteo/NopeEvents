package it.nopeevents.football.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PosizioneTorneo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Torneo torneo;
	
	@OneToOne
	private Squadra squadra;
	
	private Integer punti;
	
	private Integer differenzaReti;

	public PosizioneTorneo(Torneo torneo, Squadra squadra) {
		this.torneo = torneo;
		this.squadra = squadra;
		this.punti = 0;
		this.differenzaReti = 0;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}

	public Integer getPunti() {
		return punti;
	}

	public void setPunti(Integer punti) {
		this.punti = punti;
	}

	public Integer getDifferenzaReti() {
		return differenzaReti;
	}

	public void setDifferenzaReti(Integer differenzaReti) {
		this.differenzaReti = differenzaReti;
	}
}
