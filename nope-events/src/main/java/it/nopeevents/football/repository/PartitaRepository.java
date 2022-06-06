package it.nopeevents.football.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.nopeevents.football.model.Partita;

public interface PartitaRepository extends CrudRepository<Partita,Long> {

	List<Partita> findByTorneoIdOrderByGiornataAsc(Long torneo_id);

}
