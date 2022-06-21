package it.nopeevents.football.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.nopeevents.football.model.Squadra;
import it.nopeevents.football.model.Torneo;
import it.nopeevents.football.service.SquadraService;
import it.nopeevents.football.service.TorneoService;
import it.nopeevents.football.validator.SquadraValidator;

@Controller
public class SquadraController {

	@Autowired
	private SquadraService squadraService;

	@Autowired
	private TorneoService torneoService;

	@Autowired
	private SquadraValidator squadraValidator;

	@PostMapping("/admin/squadraForm")
	public String addSquadra(@Valid @ModelAttribute("squadra") Squadra squadra, BindingResult bindingResults, Model model) {
		squadraValidator.validate(squadra,  bindingResults);
		if(!bindingResults.hasErrors()) {
			squadraService.save(squadra);
			model.addAttribute("squadra", squadra);
			for(int i= 0; i < squadra.getTornei().size() ; i++ ) {
				Torneo t = squadra.getTornei().get(i);
				t.getSquadrePartecipanti().add(squadra);
				torneoService.save(t);
			}
			return "redirect:/admin/squadraForm";
		}
		List<Torneo> listTornei = torneoService.findAll();
		model.addAttribute("listTornei", listTornei);
		return "squadra/squadraForm.html";
	}


	@GetMapping("/admin/squadraForm")
	public String getSquadre(Model model) {
		model.addAttribute("squadra", new Squadra());
		List<Torneo> listTornei = torneoService.findAll();
		model.addAttribute("listTornei", listTornei);
		return "squadra/squadraForm.html";
	}
}
