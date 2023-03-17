package fr.jd.fitnessDev.serviceImpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.jd.fitnessDev.model.Plat;
import fr.jd.fitnessDev.model.Seance;
import fr.jd.fitnessDev.model.Utilisateur;
import fr.jd.fitnessDev.repository.UtilisateurRepository;
import fr.jd.fitnessDev.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur create(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> read() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur update(Long id, Utilisateur utilisateur) {
        return utilisateurRepository.findById(id)
        .map(u -> {
            u.setNom(utilisateur.getNom());
            u.setPrenom(utilisateur.getPrenom());
            u.setGenre(utilisateur.getGenre());
            u.setAge(utilisateur.getAge());
            u.setTaille(utilisateur.getTaille());
            u.setPoids(utilisateur.getPoids());
            u.setApportJournalier(utilisateur.getApportJournalier());
            
            List<Plat> updatedPlats = utilisateur.getLstPlat();
            
            if (updatedPlats != null && !updatedPlats.isEmpty()) {
                List<Plat> existingPlats = u.getLstPlat();
                if (existingPlats == null) {
                    existingPlats = new ArrayList<>();
                }
                // On efface la liste existante avant d'ajouter les nouvelles valeurs
                existingPlats.clear(); 
                
                for (Plat updatedPlat : updatedPlats) {
                    // On vérifie que le plat n'existe pas déjà dans la liste existante
                    if (!existingPlats.contains(updatedPlat)) {
                        existingPlats.add(updatedPlat);
                    }
                }
                u.setLstPlat(existingPlats);
            }

            List<Seance> updatedSeances = utilisateur.getLstSeance();

            if (updatedSeances != null && !updatedSeances.isEmpty()) {
                List<Seance> existingSeances = u.getLstSeance();
                if (existingSeances == null) {
                    existingSeances = new ArrayList<>();
                }
                // On efface la liste existante avant d'ajouter les nouvelles valeurs
                existingSeances.clear(); 
                
                for (Seance updatedSeance : updatedSeances) {
                    // On vérifie que la séance n'existe pas déjà dans la liste existante
                    if (!existingSeances.contains(updatedSeance)) {
                        existingSeances.add(updatedSeance);
                    }
                }
                u.setLstSeance(existingSeances);
            }

            return utilisateurRepository.save(u);
        }).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé !"));
    }

    @Override
    public String delete(Long id) {
    	utilisateurRepository.deleteById(id);
        return "Utilisateur supprimé";
    }
    
}
