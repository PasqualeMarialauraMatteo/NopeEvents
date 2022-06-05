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
	
	private Long partiteGiocate;
	
	public PosizioneTorneo() {
	
	}

	public PosizioneTorneo(Torneo torneo, Squadra squadra) {
		this.torneo = torneo;
		this.squadra = squadra;
		this.punti = (long)0;
		this.differenzaReti = (long)0;
		this.partiteGiocate = (long)0;
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

	public Long getPartiteGiocate() {
		return partiteGiocate;
	}

	public void setPartiteGiocate(Long partiteGiocate) {
		this.partiteGiocate = partiteGiocate;
	}

	public void registerEsito(Long golFatti, Long golSubiti) {
		this.aggiornaDifferenzaReti(golFatti,golSubiti);
		this.aggiornaPunti(golFatti,golSubiti);
		this.partiteGiocate = this.partiteGiocate + 1;
	}

	private void aggiornaPunti(Long golFatti, Long golSubiti) {
		long punti = 1;
		
		if(golFatti > golSubiti) punti = 3;
		else if(golFatti < golSubiti) punti = 0;
		
		long nuoviPunti = this.getPunti() + punti;
		this.setPunti(nuoviPunti);
	}

	private void aggiornaDifferenzaReti(Long golFatti, Long golSubiti) {
		Long nuovaDifferenzaReti = this.getDifferenzaReti();
		
		nuovaDifferenzaReti += (golFatti - golSubiti);
		this.setDifferenzaReti(nuovaDifferenzaReti);
	}
}
