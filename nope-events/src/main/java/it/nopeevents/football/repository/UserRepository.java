package it.nopeevents.football.repository;

import org.springframework.data.repository.CrudRepository;

import it.nopeevents.football.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}