package fr.jd.fitnessDev.serviceImpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.jd.fitnessDev.model.Exercice;
import fr.jd.fitnessDev.model.Seance;
import fr.jd.fitnessDev.repository.SeanceRepository;
import fr.jd.fitnessDev.service.SeanceService;

@Service
public class SeanceServiceImpl implements SeanceService {

    private final SeanceRepository seanceRepository;

    @Override
    public Seance create(Seance seance) {
        return seanceRepository.save(seance);
    }

    @Override
    public List<Seance> read() {
        return seanceRepository.findAll();
    }

    @Override
    public Seance update(Long id, Seance seance) {
        return seanceRepository.findById(id)
        .map(s -> {
            s.setNom(seance.getNom());
            s.setImage(seance.getImage());
            s.setActive(seance.isActive());
            
            List<Exercice> updatedExercices = seance.getLstExercice();
            
            if (updatedExercices != null && !updatedExercices.isEmpty()) {
                List<Exercice> existingExercices = s.getLstExercice();
                if (existingExercices == null) {
                    existingExercices = new ArrayList<>();
                }
                // On efface la liste existante avant d'ajouter les nouvelles valeurs
                existingExercices.clear(); 
                
                for (Exercice updatedExercice : updatedExercices) {
                    // On vérifie que l'exercice n'existe pas déjà dans la liste existante
                    if (!existingExercices.contains(updatedExercice)) {
                        existingExercices.add(updatedExercice);
                    }
                }
                s.setLstExercice(existingExercices);
            }
            return seanceRepository.save(s);
        }).orElseThrow(() -> new RuntimeException("Séance non trouvée !"));
    }

    @Override
    public String delete(Long id) {
        seanceRepository.deleteById(id);
        return "Séance supprimée";
    }
    
}
