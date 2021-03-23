package dev.jeniffer.recipebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jeniffer.recipebook.model.Ingredient;
import dev.jeniffer.recipebook.model.RecipeIngredient;
import dev.jeniffer.recipebook.model.RecipeIngredientKey;

import java.util.List;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, RecipeIngredientKey>{
	List<RecipeIngredient> findByRecipeId(Long recipeId);

}
