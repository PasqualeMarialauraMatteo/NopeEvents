package it.nopeevents.football.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.nopeevents.football.model.PosizioneTorneo;

public interface PosizioneRepository extends CrudRepository<PosizioneTorneo,Long> {
	
	public List<PosizioneTorneo> findByTorneoIdOrderByPuntiDescPartiteGiocateAscDifferenzaRetiDesc(Long torneo_id);
	
}
