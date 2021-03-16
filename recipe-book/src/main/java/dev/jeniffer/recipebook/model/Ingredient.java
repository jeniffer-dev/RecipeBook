package dev.jeniffer.recipebook.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ingredient")
public class Ingredient {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "ingredient")
	private List<RecipeIngredient> recipeIngredients;
	

	public Ingredient() {
		super();
	}

	public Ingredient(String name, List<RecipeIngredient> recipeIngredients) {
		super();
		this.name = name;
		this.recipeIngredients = recipeIngredients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonBackReference
	public List<RecipeIngredient> getRecipeIngredients() {
		return recipeIngredients;
	}

	public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}
	
	
 
}
