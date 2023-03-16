package fr.jd.fitnessDev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.jd.fitnessDev.model.Exercice;

public interface ExerciceRepository extends JpaRepository<Exercice, Long> {

}
