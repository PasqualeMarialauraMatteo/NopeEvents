package it.nopeevents.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.nopeevents.football.service.PosizioneService;

@Controller
public class PosizioneController {

	@Autowired PosizioneService posizioneService;
	
	@GetMapping("/classifica/{id}")
	public String showClassifica(@PathVariable Long id, Model model) {
		model.addAttribute("classifica", posizioneService.findAllByTorneo(id));
		return "classifica/classifica.html";
	}
}
