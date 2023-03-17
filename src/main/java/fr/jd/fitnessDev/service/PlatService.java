package fr.jd.fitnessDev.service;

import java.util.List;

import fr.jd.fitnessDev.model.Plat;

public interface PlatService {
    
    Plat create(Plat plat);
    
    List<Plat> read();

    Plat update(Long id, Plat plat);

    String delete(Long id);
    
}
