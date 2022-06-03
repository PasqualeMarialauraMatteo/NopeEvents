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
		Squadra A = new Squadra("AC Belluno");
		Squadra B = new Squadra("Bolognesi FC");
		Squadra C = new Squadra("Calvoirada");
		Squadra D = new Squadra("Dominiosi");
		Squadra E = new Squadra("Elefanti");
		Squadra F = new Squadra("Ferentina");
		
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
		t1.setDescrizione("Calcio a 5, una partita a settimana");
		t1.setMontepremi((long)20);
		
		List<Squadra> newPartecipanti = new ArrayList<>();
		newPartecipanti.addAll(partecipanti);
		newPartecipanti.add(E);
		newPartecipanti.add(F);
		
		Torneo t2 = new Torneo("T2", newPartecipanti);
		t2.setDescrizione("Calcio a 7, due partite a settimana");
		t2.setMontepremi((long)20);
		
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
