package it.nopeevents.football.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nopeevents.football.model.PosizioneTorneo;
import it.nopeevents.football.repository.PosizioneRepository;

@Service
public class PosizioneService {
	
	@Autowired private PosizioneRepository posizioneRepository;
	
	@Transactional
	public void save(PosizioneTorneo posizione) {
		posizioneRepository.save(posizione);
	}
}
