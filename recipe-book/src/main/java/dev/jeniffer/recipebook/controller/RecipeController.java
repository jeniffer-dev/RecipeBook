package dev.jeniffer.recipebook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import dev.jeniffer.recipebook.service.RecipeService;
import dev.jeniffer.recipebook.exception.ResourceNotFoundException;
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
	
	@Autowired
	private RecipeService recipeService;
	
	@GetMapping("")
	public ResponseEntity<List<Recipe>> getAllRecipes() {
		List<Recipe> recipes = this.recipeRepository.findAll();
		
		if (recipes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		}
		
		return new ResponseEntity<>(recipes, HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) throws ResourceNotFoundException {
		Recipe recipe = recipeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found recipe with id: " + id));
		return new ResponseEntity<>(recipe, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
		this.recipeRepository.save(recipe);
		List<RecipeIngredient> recipeIngredients = recipe.getRecipeIngredients();
		if (recipeIngredients != null) {
			List<RecipeIngredient> savedRecipeIngredients = new ArrayList<>();
			recipeIngredients.forEach(recipeIng -> {
				Ingredient ingredient = ingredientRepository.findByName(recipeIng.getIngredient().getName());
				if (ingredient == null) {
					ingredient = recipeIng.getIngredient();
					this.ingredientRepository.save(ingredient);
				}
				recipeIng.setIngredient(ingredient);
				recipeIng.setRecipe(recipe);
				this.recipeIngredientRepository.save(recipeIng);
				savedRecipeIngredients.add(recipeIng);
			});
			recipe.setRecipeIngredients(savedRecipeIngredients);
		}
		return new ResponseEntity<>(recipe, HttpStatus.CREATED);
	}
	
	@PutMapping("/{recipeId}") 
	public ResponseEntity<Recipe> updateRecipe(@PathVariable Long recipeId,
			@RequestBody Recipe recipeRequest) {
		try {
			return new ResponseEntity<>(recipeService.updateRecipe(recipeId, recipeRequest), HttpStatus.OK);
		} catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
			
	}
	
	@DeleteMapping("")
	public ResponseEntity<Recipe> deleteRecipes() {
		recipeRepository.deleteAll();
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{recipeId}")
	public ResponseEntity<Recipe> deleteRecipe(@PathVariable Long recipeId) {
		recipeRepository.deleteById(recipeId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/{recipeId}/instructions")
	public ResponseEntity<Instruction> createInstruction(@PathVariable Long recipeId, 	
			@RequestBody Instruction instruction) throws ResourceNotFoundException {
		Recipe recipe = recipeRepository.findById(recipeId)
				.orElseThrow(() -> new ResourceNotFoundException("Not found recipe with id: " + recipeId));
			instruction.setRecipe(recipe);
		return new ResponseEntity<>(instructionRepository.save(instruction), HttpStatus.OK);
					
	}
	

}
