package dev.jeniffer.recipebook.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient {
	
	@EmbeddedId
	private RecipeIngredientKey id;
	
	@ManyToOne
	@MapsId("recipeId")
	@JoinColumn(name = "recipe_id")
	@JsonIgnore
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
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeIngredient other = (RecipeIngredient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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
