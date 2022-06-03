package it.nopeevents.football.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public final class AutheticationController {

	@GetMapping(value = "/admin")
    public String defaultAfterLogin(Model model) {
		//per il momento solo accesso all index dell admin
        return "adminIndex.html";
    }
}
