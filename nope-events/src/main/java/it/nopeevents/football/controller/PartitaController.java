package it.nopeevents.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.nopeevents.football.service.PartitaService;

@Controller
public class PartitaController {
	
	@Autowired PartitaService partitaService;
	
	@GetMapping("/calendario/{id}")
	public String showCalendario(@PathVariable Long id, Model model) {
		model.addAttribute("calendario", partitaService.findByTorneo(id));
		return "calendario/calendario.html";
	}
}
