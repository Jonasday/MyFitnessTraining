package fr.jd.fitnessDev.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.jd.fitnessDev.model.Ingredient;
import fr.jd.fitnessDev.repository.ExerciceRepository;
import fr.jd.fitnessDev.repository.IngredientRepository;
import fr.jd.fitnessDev.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    
    @Override
    public Ingredient create(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public List<Ingredient> read() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient update(Long id, Ingredient ingredient) {
        return ingredientRepository.findById(id)
        .map(i-> {
            i.setNom(ingredient.getNom());
            i.setCategorie(ingredient.getCategorie());
            i.setKcal(ingredient.getKcal());
            i.setGlucide(ingredient.getGlucide());
            i.setSucre(ingredient.getSucre());
            i.setLipide(ingredient.getLipide());
            i.setAcideGras(ingredient.getAcideGras());
            i.setFibre(ingredient.getFibre());
            i.setProteine(ingredient.getProteine());
            i.setSel(ingredient.getSel());
            return ingredientRepository.save(i);
        }).orElseThrow(() -> new RuntimeException("Ingredient non trouvé !"));
    }

    @Override
    public String delete(Long id) {
        ingredientRepository.deleteById(id);
        return "Ingredient supprimé";
    }
}
