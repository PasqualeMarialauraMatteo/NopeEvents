package it.nopeevents.football.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String addTorneo(@Valid @ModelAttribute("torneo") Torneo torneo, BindingResult bindingResults, Model model,@RequestParam("dataInizio") 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
		torneoValidator.validate(torneo,  bindingResults);
		if(!bindingResults.hasErrors()) {
			torneoService.save(torneo);
			model.addAttribute("torneo", torneo);
			return "redirect:/admin/torneoForm";
		}
		model.addAttribute("tornei", torneoService.findAll());
		return "torneo/torneoForm.html";
	}
	
	@GetMapping("/admin/torneoForm")
	public String getTorneoForm(Model model) {
		model.addAttribute("torneo", new Torneo());
		model.addAttribute("tornei", torneoService.findAll());
		return "torneo/torneoForm.html";
	}
	
	@GetMapping("/tornei")
	public String showTornei(Model model) {
		model.addAttribute("tornei", torneoService.findAll());
		return "torneo/tornei.html";
	}
	
	@GetMapping("/admin/chiudiIscrizione/{id}")
	public String chiudiIscrizioneTorneo(@PathVariable("id") Long id, Model model) {
		Torneo torneo = torneoService.findById(id);
		torneo.terminaIscrizione();
		torneoService.saveAll(torneo);
		return  "redirect:/admin/torneoForm";
	}
	
}
