package it.nopeevents.football.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nopeevents.football.model.Torneo;
import it.nopeevents.football.repository.TorneoRepository;

@Service
public class TorneoService {

	@Autowired private TorneoRepository torneoRepository;
	
	@Transactional
	public void save(Torneo torneo) {
		torneoRepository.save(torneo);
	}
}
