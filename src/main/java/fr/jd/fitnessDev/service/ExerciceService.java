package fr.jd.fitnessDev.service;

import java.util.List;

import fr.jd.fitnessDev.model.Exercice;

public interface ExerciceService {
    
    Exercice create(Exercice exercice);
    
    Exercice detail(Long id);

    List<Exercice> read();

    Exercice update(Long id, Exercice exercice);

    String delete(Long id);
    
}
