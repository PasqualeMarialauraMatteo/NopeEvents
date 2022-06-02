package it.nopeevents.football.service;

import java.util.ArrayList;
import java.util.List;

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
	@Transactional
	public Torneo findById(Long id) {
		return torneoRepository.findById(id).get();
	}
	
	@Transactional
	public boolean alreadyExists(Torneo torneo) {
		return torneoRepository.existsByNomeAndDescrizioneAndDataInizio(torneo.getNome(), torneo.getDescrizione(), torneo.getDataInizio());
	}
	
	@Transactional
	public List<Torneo> findAll(){
		List<Torneo> tornei = new ArrayList<Torneo>();
		for(Torneo t : torneoRepository.findAll()) {
			tornei.add(t);
		}
		return tornei;
	}

	@Transactional
	public void remove(Long id) {
		torneoRepository.deleteById(id);
	}
}
