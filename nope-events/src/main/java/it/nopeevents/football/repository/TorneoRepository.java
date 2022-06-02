package it.nopeevents.football.repository;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;

import it.nopeevents.football.model.Torneo;

public interface TorneoRepository extends CrudRepository<Torneo,Long> {
	public boolean existsByNomeAndDescrizioneAndDataInizio(String nome,String descrizione, LocalDate dataInizio);
}
