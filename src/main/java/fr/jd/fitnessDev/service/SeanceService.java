package fr.jd.fitnessDev.service;

import java.util.List;

import fr.jd.fitnessDev.model.Seance;

public interface SeanceService {

    Seance create(Seance seance);

    List<Seance> read();

    Seance update(Long id, Seance seance);

    String delete(Long id);
    
}
