package it.nopeevents.football.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.nopeevents.football.model.Credentials;

public interface CredentialsRepository extends CrudRepository<Credentials, Long> {
	
	public Optional<Credentials> findByUsername(String username);

}