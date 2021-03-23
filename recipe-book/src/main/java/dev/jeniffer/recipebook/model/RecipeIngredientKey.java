package dev.jeniffer.recipebook.model;

import java.io.Serializable;
import java.util.Objects;

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
		return Objects.hash(getIngredientId(), getRecipeId());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
        if (!(o instanceof RecipeIngredientKey)) return false;
        RecipeIngredientKey that = (RecipeIngredientKey) o;
        return Objects.equals(getRecipeId(), that.getRecipeId()) &&
                Objects.equals(getIngredientId(), that.getIngredientId());
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
