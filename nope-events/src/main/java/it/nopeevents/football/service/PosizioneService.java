package it.nopeevents.football.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<PosizioneTorneo> findAll() {
		Iterable<PosizioneTorneo> all = posizioneRepository.findAll();
		List<PosizioneTorneo> output = new ArrayList<>();
		
		for(PosizioneTorneo p: all) output.add(p);
		return output;
	}

	public List<PosizioneTorneo> findAllByTorneo(Long torneo_id) {
		return posizioneRepository.findByTorneoIdOrderByPuntiDescPartiteGiocateAscDifferenzaRetiDesc(torneo_id);
	}
}
