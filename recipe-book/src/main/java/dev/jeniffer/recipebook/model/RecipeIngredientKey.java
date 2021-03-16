package dev.jeniffer.recipebook.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RecipeIngredientKey implements Serializable {
	
	@Column(name = "recipe_id")
	Long recipeId;
	
	@Column(name = "ingredient_id")
	Long ingredientId;

	public RecipeIngredientKey() {
		super();
	}

	public RecipeIngredientKey(Long recipeId, Long ingredientId) {
		super();
		this.recipeId = recipeId;
		this.ingredientId = ingredientId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredientId == null) ? 0 : ingredientId.hashCode());
		result = prime * result + ((recipeId == null) ? 0 : recipeId.hashCode());
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
		RecipeIngredientKey other = (RecipeIngredientKey) obj;
		if (ingredientId == null) {
			if (other.ingredientId != null)
				return false;
		} else if (!ingredientId.equals(other.ingredientId))
			return false;
		if (recipeId == null) {
			if (other.recipeId != null)
				return false;
		} else if (!recipeId.equals(other.recipeId))
			return false;
		return true;
	}

	public Long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}

	public Long getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(Long ingredientId) {
		this.ingredientId = ingredientId;
	}
	
	
}
