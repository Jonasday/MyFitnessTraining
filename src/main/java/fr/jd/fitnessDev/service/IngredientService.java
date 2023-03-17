package fr.jd.fitnessDev.service;

import java.util.List;

import fr.jd.fitnessDev.model.Ingredient;

public interface IngredientService {

    Ingredient create(Ingredient ingredient);

    List<Ingredient> read();

    Ingredient update(Long id, Ingredient ingredient);

    String delete(Long id);
    
}
