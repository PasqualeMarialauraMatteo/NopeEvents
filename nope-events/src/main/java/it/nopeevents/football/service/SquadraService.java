package it.nopeevents.football.service;

import java.util.ArrayList;
import java.util.List;

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
	
	@Transactional
	public Squadra findById(Long id) {
		return squadraRepository.findById(id).get();
	}
	
	@Transactional
	public List<Squadra> findAll(){
		List<Squadra> squadre = new ArrayList<Squadra>();
		for(Squadra s : squadraRepository.findAll()) {
			squadre.add(s);
		}
		return squadre;
	}
	
	@Transactional
	public boolean alreadyExists(Squadra squadra) {
		return squadraRepository.existsByNome(squadra.getNome());
	}
	
	@Transactional
	public void remove(Long id) {
		squadraRepository.deleteById(id);
	}
}
