package it.nopeevents.football.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nopeevents.football.model.Squadra;
import it.nopeevents.football.repository.SquadraRepository;

@Service
public class SquadraService {

	@Autowired private SquadraRepository squadraRepository;
	
	@Transactional
	public void save(Squadra squadra) {
		squadraRepository.save(squadra);
	}
}
