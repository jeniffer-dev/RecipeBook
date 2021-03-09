package dev.jeniffer.recipebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jeniffer.recipebook.repository.RecipeRepository;
import dev.jeniffer.recipebook.exception.ResourceNotFoundException;
import dev.jeniffer.recipebook.model.Recipe;

@RestController
@RequestMapping("/api/v1/")
public class RecipeController {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@GetMapping("recipes")
	public List<Recipe> getAllRecipe() {
		return this.recipeRepository.findAll();
	}
	
	@GetMapping("recipes/{id}")
	public ResponseEntity<Recipe> getRecipeById(@PathVariable(value = "id") Long recipeId)
		throws ResourceNotFoundException {
		Recipe recipe = recipeRepository.findById(recipeId)
				.orElseThrow(() -> new ResourceNotFoundException("Recipe not found for this id: " + recipeId));
		return ResponseEntity.ok().body(recipe);
	}
	
	@PostMapping("recipes")
	public Recipe createRecipe(@RequestBody Recipe recipe) {
		return this.recipeRepository.save(recipe);
	}
	
	
	

}
