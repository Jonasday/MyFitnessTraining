package fr.jd.fitnessDev.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.jd.fitnessDev.model.Ingredient;
import fr.jd.fitnessDev.model.Plat;
import fr.jd.fitnessDev.repository.PlatRepository;
import fr.jd.fitnessDev.service.PlatService;

@Service
public class PlatServiceImpl implements PlatService {

    private final PlatRepository platRepository;

    @Override
    public Plat create(Plat plat) {
        return platRepository.save(plat);
    }

    @Override
    public List<Plat> read() {
        return platRepository.findAll();
    }

    @Override
    public Plat update(Long id, Plat plat) {
        return platRepository.findById(id)
        .map(p -> {
            p.setNom(plat.getNom());
            p.setImage(plat.getImage());
            
            List<Ingredient> updatedIngredients = plat.getLstIngredient();
            
            if (updatedIngredients != null && !updatedIngredients.isEmpty()) {
                List<Ingredient> existingIngredients = p.getLstIngredient();
                if (existingIngredients == null) {
                    existingIngredients = new ArrayList<>();
                }
                // On efface la liste existante avant d'ajouter les nouvelles valeurs
                existingIngredients.clear(); 
                
                for (Ingredient updatedIngredient : updatedIngredients) {
                    // On vérifie que l'ingredient n'existe pas déjà dans la liste existante
                    if (!existingIngredients.contains(updatedIngredient)) {
                        existingIngredients.add(updatedIngredient);
                    }
                }
                p.setLstIngredient(existingIngredients);
            }
            return platRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Plat non trouvé !"));
    }

    @Override
    public String delete(Long id) {
        platRepository.deleteById(id);
        return "Plat supprimé";
    }
    
}