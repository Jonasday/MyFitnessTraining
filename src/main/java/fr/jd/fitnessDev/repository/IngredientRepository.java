package fr.jd.fitnessDev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.jd.fitnessDev.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
