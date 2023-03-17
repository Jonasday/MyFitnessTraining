package fr.jd.fitnessDev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.jd.fitnessDev.model.Exercice;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice, Long> {

}
