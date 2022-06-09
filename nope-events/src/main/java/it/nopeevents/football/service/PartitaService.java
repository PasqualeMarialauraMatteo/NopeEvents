package it.nopeevents.football.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nopeevents.football.model.Partita;
import it.nopeevents.football.repository.PartitaRepository;

@Service
public class PartitaService {

	@Autowired private PartitaRepository partitaRepository;
	
	@Transactional
	public void save(Partita partita) {
		partitaRepository.save(partita);
	}
	
	public Partita findById(Long id) {
		return partitaRepository.findById(id).get();
	}

	public List<Partita> findByTorneo(Long torneo_id) {
		return partitaRepository.findByTorneoIdOrderByGiornataAsc(torneo_id);
	}

}
