package it.nopeevents.football.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.nopeevents.football.model.Squadra;

public interface SquadraRepository extends CrudRepository<Squadra,Long> {

	boolean existsByNome(String nome);

	
}
