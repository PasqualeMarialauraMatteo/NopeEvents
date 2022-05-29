package it.nopeevents.football;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.nopeevents.football.model.Squadra;
import it.nopeevents.football.model.Torneo;
import it.nopeevents.football.service.PartitaService;
import it.nopeevents.football.service.PosizioneService;
import it.nopeevents.football.service.SquadraService;
import it.nopeevents.football.service.TorneoService;

@SpringBootApplication
public class NopeEventsApplication implements CommandLineRunner {

	@Autowired PartitaService ptS;
	@Autowired PosizioneService pzS;
	@Autowired TorneoService tS;
	@Autowired SquadraService sS;
	
	public static void main(String[] args) {
		SpringApplication.run(NopeEventsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Squadra A = new Squadra("A");
		Squadra B = new Squadra("B");
		Squadra C = new Squadra("C");
		
		sS.save(A);
		sS.save(B);
		sS.save(C);
		
		List<Squadra> partecipanti = new ArrayList<>();
		partecipanti.add(A);
		partecipanti.add(B);
		partecipanti.add(C);
		
		Torneo t = new Torneo("Torneo", partecipanti);
		
		tS.save(t);
	}

}
