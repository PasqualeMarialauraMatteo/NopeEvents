package it.nopeevents.football;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.nopeevents.football.model.Partita;
import it.nopeevents.football.model.Squadra;
import it.nopeevents.football.model.Torneo;
import it.nopeevents.football.service.PartitaService;
import it.nopeevents.football.service.SquadraService;
import it.nopeevents.football.service.TorneoService;

@SpringBootApplication
public class NopeEventsApplication implements CommandLineRunner {

	@Autowired PartitaService ptS;
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
		Squadra D = new Squadra("D");
		Squadra E = new Squadra("E");
		Squadra F = new Squadra("F");
		
		sS.save(A);
		sS.save(B);
		sS.save(C);
		sS.save(D);
		sS.save(E);
		sS.save(F);
		
		List<Squadra> partecipanti = new ArrayList<>();
		partecipanti.add(A);
		partecipanti.add(B);
		partecipanti.add(C);
		partecipanti.add(D);
				
		Torneo t1 = new Torneo("T1", partecipanti);
		
		List<Squadra> newPartecipanti = new ArrayList<>();
		newPartecipanti.addAll(partecipanti);
		newPartecipanti.add(E);
		newPartecipanti.add(F);
		
		Torneo t2 = new Torneo("T2", newPartecipanti);
		
		Partita p = t1.getPartite().get(0);
		p.setGolCasa((long)2);
		p.setGolTrasferta((long)1);
		p.setGiocata();
		
		p = t1.getPartite().get(1);
		p.setGolCasa((long)3);
		p.setGolTrasferta((long)0);
		p.setGiocata();
		
		p = t1.getPartite().get(2);
		p.setGolCasa((long)3);
		p.setGolTrasferta((long)1);
		p.setGiocata();
		
		tS.save(t1);
		tS.save(t2);
	}

}
