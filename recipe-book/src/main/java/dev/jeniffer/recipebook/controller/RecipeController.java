package dev.jeniffer.recipebook.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jeniffer.recipebook.repository.IngredientRepository;
import dev.jeniffer.recipebook.repository.InstructionRepository;
import dev.jeniffer.recipebook.repository.RecipeIngredientRepository;
import dev.jeniffer.recipebook.repository.RecipeRepository;
import dev.jeniffer.recipebook.model.Ingredient;
import dev.jeniffer.recipebook.model.Instruction;
import dev.jeniffer.recipebook.model.Recipe;
import dev.jeniffer.recipebook.model.RecipeIngredient;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/recipes")
public class RecipeController {
	
	@Autowired
	private RecipeRepository recipeRepository;
		
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Autowired
	private RecipeIngredientRepository recipeIngredientRepository;
	
	@Autowired
	private InstructionRepository instructionRepository; 
	
	@GetMapping("")
	public List<Recipe> getAllRecipes() {
		return this.recipeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Recipe>> getRecipeById(@PathVariable Long id) {
		Optional<Recipe> recipe = recipeRepository.findById(id);
		return ResponseEntity.ok().body(recipe);
	}
	
	@PostMapping("")
	public Recipe createRecipe(@RequestBody Recipe recipe) {
		this.recipeRepository.save(recipe);
		List<RecipeIngredient> recipeIngredients = recipe.getRecipeIngredients();
		if (recipeIngredients != null) {
			List<RecipeIngredient> savedRecipeIngredients = new ArrayList<>();
			recipeIngredients.forEach(recipeIng -> {
				Ingredient ingredient = recipeIng.getIngredient();
				recipeIng.setRecipe(recipe);
				recipeIng.setIngredient(ingredient);
				this.ingredientRepository.save(ingredient);
				this.recipeIngredientRepository.save(recipeIng);
				savedRecipeIngredients.add(recipeIng);
			});
			recipe.setRecipeIngredients(savedRecipeIngredients);
		}
		return recipe;
	}
	
	@PutMapping("/{recipeId}") 
	public Optional<Object> updateRecipe(@PathVariable Long recipeId,
			@RequestBody Recipe recipeRequest) {
		if(!recipeRepository.existsById(recipeId)) {
		}
		return recipeRepository.findById(recipeId).map(recipe -> {
			recipe.setName(recipeRequest.getName());
			recipe.setCookTime(recipeRequest.getCookTime());
			recipe.setPreparationTime(recipeRequest.getPreparationTime());
			return recipeRepository.save(recipe);
		});
	}
	
	@DeleteMapping("")
	public void deleteRecipes() {
		recipeRepository.deleteAll();
	}
	
	@DeleteMapping("/{recipeId}")
	public void deleteRecipe(@PathVariable Long recipeId) {
		recipeRepository.deleteById(recipeId);
	}
	
	@PostMapping("/{recipeId}/instructions")
	public Optional<Instruction> createInstruction(@PathVariable Long recipeId, 	
			@RequestBody Instruction instruction) {
		return recipeRepository.findById(recipeId).map(recipe -> {
			instruction.setRecipe(recipe);
			return instructionRepository.save(instruction);
		});	
	}
	
	@PutMapping("/{recipeId}/instructions/{instructionId}")
	public Optional<Instruction> updateInstruction(@PathVariable Long recipeId,
			@PathVariable Long instructionId,
			@RequestBody Instruction instructionRequest) {
		return instructionRepository.findById(instructionId).map(instruction -> {
			instruction.setStepDescription(instructionRequest.getStepDescription());
			return instructionRepository.save(instruction);
		});
		
	}
	

}
