package dev.jeniffer.recipebook.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jeniffer.recipebook.model.Ingredient;
import dev.jeniffer.recipebook.model.Instruction;
import dev.jeniffer.recipebook.model.Recipe;
import dev.jeniffer.recipebook.model.RecipeIngredient;
import dev.jeniffer.recipebook.repository.IngredientRepository;
import dev.jeniffer.recipebook.repository.RecipeIngredientRepository;
import dev.jeniffer.recipebook.repository.RecipeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/recipes")
public class IngredientController {
	
	@Autowired 
	private RecipeIngredientRepository recipeIngredientRepository;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@GetMapping("{recipeId}/recipeIngredients")
	public List<RecipeIngredient> getIngredientsByRecipeId(@PathVariable Long recipeId) {
		return this.recipeIngredientRepository.findByRecipeId(recipeId);
	}

	@PostMapping("{recipeId}/recipeIngredients")
	public List<RecipeIngredient> createRecipeIngredient(@PathVariable Long recipeId, 	
			@RequestBody List<RecipeIngredient> recipeIngredients) {
		recipeRepository.findById(recipeId).map(recipe -> {
			List<RecipeIngredient> addedRecipeIng = new ArrayList<>();
			recipeIngredients.forEach(recipeIngredient -> {
				recipeIngredient.setRecipe(recipe);
				Ingredient ingredient = recipeIngredient.getIngredient();
				ingredientRepository.save(ingredient);
				addedRecipeIng.add(recipeIngredient);
			});
			return recipeIngredientRepository.saveAll(addedRecipeIng);

		});
		return null;
		
	}

}
