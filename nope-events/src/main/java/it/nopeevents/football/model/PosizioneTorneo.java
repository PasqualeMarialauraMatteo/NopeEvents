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
	
	private Long punti;
	
	private Long differenzaReti;

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

	public Long getPunti() {
		return punti;
	}

	public void setPunti(Long punti) {
		this.punti = punti;
	}

	public Long getDifferenzaReti() {
		return differenzaReti;
	}

	public void setDifferenzaReti(Long differenzaReti) {
		this.differenzaReti = differenzaReti;
	}
}
