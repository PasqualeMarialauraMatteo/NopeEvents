package it.nopeevents.football.repository;

import org.springframework.data.repository.CrudRepository;

import it.nopeevents.football.model.Squadra;

public interface SquadraRepository extends CrudRepository<Squadra,Long> {

	boolean existsByNome(String nome);

	
}
