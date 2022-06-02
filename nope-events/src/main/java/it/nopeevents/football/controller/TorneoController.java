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

import it.nopeevents.football.model.Torneo;
import it.nopeevents.football.service.TorneoService;
import it.nopeevents.football.validator.TorneoValidator;

@Controller
public class TorneoController {
	@Autowired
	private TorneoService torneoService;

	@Autowired
	private TorneoValidator torneoValidator;
	
	@PostMapping("/admin/torneoForm")
	public String addTorneo(@Valid @ModelAttribute("torneo") Torneo torneo, BindingResult bindingResults, Model model) {
		torneoValidator.validate(torneo,  bindingResults);
		if(!bindingResults.hasErrors()) {
			torneoService.save(torneo);
			model.addAttribute("torneo", torneo);
			return "redirect:/admin/torneoForm";
		}
		List<Torneo> tornei = torneoService.findAll();
		model.addAttribute("tornei", tornei);
		return "torneo/torneoForm.html";
	}
	
	@GetMapping("/admin/torneoForm")
	public String getTorneoForm(Model model) {
		model.addAttribute("torneo", new Torneo());
		return "torneo/torneoForm.html";
	}
	
}
