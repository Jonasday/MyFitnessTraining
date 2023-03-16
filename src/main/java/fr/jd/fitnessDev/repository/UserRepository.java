package fr.jd.fitnessDev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.jd.fitnessDev.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
