package dev.jeniffer.recipebook.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jeniffer.recipebook.model.Instruction;
import dev.jeniffer.recipebook.repository.InstructionRepository;
import dev.jeniffer.recipebook.repository.RecipeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/recipes")
public class InstructionController {

	@Autowired
	private InstructionRepository instructionRepository;

	@Autowired
	private RecipeRepository recipeRepository;

	@GetMapping("/{recipeId}/instructions")
	public Instruction getAllInstructionsByRecipeId(@PathVariable Long recipeId) {
		return (Instruction) instructionRepository.findByRecipeId(recipeId);
	}
}
