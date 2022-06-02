package it.nopeevents.football.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.nopeevents.football.model.Torneo;
import it.nopeevents.football.service.TorneoService;

public class TorneoValidator implements Validator {
	@Autowired
	private TorneoService torneoService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Torneo.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		if (this.torneoService.alreadyExists((Torneo) o)) {
			errors.reject("torneo.duplicato");
		}
	}
}
