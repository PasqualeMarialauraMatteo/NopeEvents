package it.nopeevents.football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.nopeevents.football.model.PosizioneTorneo;
import it.nopeevents.football.service.PosizioneService;

@Controller
public class PosizioneController {

	@Autowired PosizioneService posizioneService;

	@GetMapping("/classifica/{id}")
	public String showClassifica(@PathVariable Long id, Model model) {
		List<PosizioneTorneo> classifica = posizioneService.findAllByTorneo(id);

		if(!classifica.isEmpty()) {
			model.addAttribute("classifica", classifica);
			return "classifica/classifica.html";
		}
		else
			return "error.hmtl";
	}
}
