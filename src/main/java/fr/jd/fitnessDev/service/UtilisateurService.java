package fr.jd.fitnessDev.service;

import java.util.List;

import fr.jd.fitnessDev.model.Utilisateur;

public interface UtilisateurService {
    
    Utilisateur create(Utilisateur utilisateur);

    List<Utilisateur> read();

    Utilisateur update(Long id, Utilisateur utilisateur);

    String delete(Long id);
}
