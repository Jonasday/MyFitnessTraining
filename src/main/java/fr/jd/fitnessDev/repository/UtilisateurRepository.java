package fr.jd.fitnessDev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.jd.fitnessDev.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
