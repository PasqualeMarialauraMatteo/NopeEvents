package it.nopeevents.football.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.nopeevents.football.model.Squadra;
import it.nopeevents.football.service.SquadraService;

@Component
public class SquadraValidator implements Validator {


	@Autowired
	private SquadraService squadraService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Squadra.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		if (this.squadraService.alreadyExists((Squadra) o)) {
			errors.reject("squadra.duplicato");
		}
	}

}
