package it.nopeevents.football.repository;

import org.springframework.data.repository.CrudRepository;

import it.nopeevents.football.model.Torneo;

public interface TorneoRepository extends CrudRepository<Torneo,Long> {

}
