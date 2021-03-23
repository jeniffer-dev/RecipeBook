package dev.jeniffer.recipebook.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {
		"id",
	    "recipe"
	})
@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient {
	
	@EmbeddedId
	private RecipeIngredientKey id = new RecipeIngredientKey();
	
	@ManyToOne
	@MapsId("recipeId")
	@JoinColumn(name = "recipe_id")
	private Recipe recipe;
	
	@ManyToOne
	@MapsId("ingredientId")
	@JoinColumn(name = "ingredient_id")
	private Ingredient ingredient;
	
	@Column
	private int amount;
	
	@Column
	private String unit;
	
	public RecipeIngredient() {
		super();
	}

	public RecipeIngredient(Recipe recipe, Ingredient ingredient, int amount, String unit) {
		super();
		this.recipe = recipe;
		this.ingredient = ingredient;
		this.amount = amount;
		this.unit = unit;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
	
}
