package dev.jeniffer.recipebook.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "recipe")
public class Recipe {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column
	private String name;
	
	@Column(name = "image")
	private String imageUrl;
	
	@Column(name = "cook_time")
	private int cookTime;
	
	@Column(name = "preparation_time")
	private int preparationTime;
	
	@OneToMany(mappedBy = "recipe")
    private List<Instruction> instructions;
	
	@OneToMany(mappedBy = "recipe")
	private List<RecipeIngredient> recipeIngredients;
	
	public Recipe() {
		super();
	}

	public Recipe(long id, String name, String imageUrl, int cookTime, int preparationTime, List<Instruction> instructions,
			List<RecipeIngredient> recipeIngredients) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.cookTime = cookTime;
		this.preparationTime = preparationTime;
		this.instructions = instructions;
		this.recipeIngredients = recipeIngredients;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getCookTime() {
		return cookTime;
	}

	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}

	public int getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(int preparationTime) {
		this.preparationTime = preparationTime;
	}

	@JsonManagedReference
	public List<Instruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	public List<RecipeIngredient> getRecipeIngredients() {
		return recipeIngredients;
	}

	public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}
	
	

}
