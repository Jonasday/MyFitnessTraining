package fr.jd.fitnessDev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.jd.fitnessDev.model.Seance;

public interface SeanceRepository extends JpaRepository<Seance, Long> {

}
