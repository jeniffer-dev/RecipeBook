package dev.jeniffer.recipebook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jeniffer.recipebook.repository.InstructionRepository;
import dev.jeniffer.recipebook.repository.RecipeRepository;
import dev.jeniffer.recipebook.model.Instruction;
import dev.jeniffer.recipebook.model.Recipe;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/recipes")
public class RecipeController {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private InstructionRepository instructionRepository;
	
	@GetMapping("")
	public List<Recipe> getAllRecipe() {
		return this.recipeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Recipe>> getRecipeById(@PathVariable(value = "id") Long recipeId) {
		Optional<Recipe> recipe = recipeRepository.findById(recipeId);
		return ResponseEntity.ok().body(recipe);
	}
	
	@PostMapping("")
	public Recipe createRecipe(@RequestBody Recipe recipe) {
		return this.recipeRepository.save(recipe);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRecipet(@PathVariable(value = "id") Long recipeId) {
		recipeRepository.deleteById(recipeId);
	}
	
	@PostMapping("/{recipeId}/instruction")
	public Optional<Object> createInstruction(@PathVariable (value = "recipeId") Long recipeId, 	
			@RequestBody Instruction instruction) {
		return recipeRepository.findById(recipeId).map(recipe -> {
			instruction.setRecipe(recipe);
			return instructionRepository.save(instruction);
		});	
	}
	

}
