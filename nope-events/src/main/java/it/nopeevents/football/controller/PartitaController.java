package it.nopeevents.football.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.nopeevents.football.model.Partita;
import it.nopeevents.football.service.PartitaService;
import it.nopeevents.football.validator.PartitaValidator;

@Controller
public class PartitaController {
	
	@Autowired PartitaService partitaService;
	
	@Autowired PartitaValidator partitaValidator;
	
	@GetMapping("/calendario/{id}")
	public String showCalendario(@PathVariable Long id, Model model) {
		model.addAttribute("calendario", partitaService.findByTorneo(id));
		return "calendario/calendario.html";
	}
	
	@GetMapping("/admin/gestisciPartite/{id}")
	public String gestisciPartite(@PathVariable("id") Long id, Model model) {
		model.addAttribute("calendario", partitaService.findByTorneo(id));
		return "calendario/set_partite.html";
	}
	
	@GetMapping("/admin/setRisultato/{id}")
	public String inserisciRisultatoForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("partita", partitaService.findById(id));
		return "calendario/set_risultato.html";		
	}

	@PostMapping("/admin/putRisultato/{id}")
	public String confermaRisultato(@PathVariable("id") Long id, @Valid @ModelAttribute("partita") Partita partita,
			BindingResult bindingResults, Model model) {
		if(!bindingResults.hasErrors()) {
			Partita old = partitaService.findById(id);
			partita.setCasa(old.getCasa());
			partita.setOspite(old.getOspite());
			partita.setGiornata(old.getGiornata());
			partita.setTorneo(old.getTorneo());
			partita.setGiocata();
			this.partitaService.save(partita);
			model.addAttribute("partita", partita);
			
			return "redirect:/admin/gestisciPartite/" + partita.getTorneo().getId().toString();
		}
		
		else
			return "calendario/set_risultato.html";
	}

}
