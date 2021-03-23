import { Injectable } from "@angular/core";
import { Subject } from "rxjs";
import { Recipe } from "../model/recipe.model";

@Injectable({providedIn: 'root'})
export class RecipeService {
  recipeChanged = new Subject<Recipe[]>();

  constructor(){}

  private recipes: Recipe[] = [];

  setRecipes(recipes: Recipe[]) {
    this.recipes = recipes;
    this.recipeChanged.next(this.recipes.slice());
    console.log(this.recipes)
  }

  getRecipes() {
    return this.recipes.slice();
  }

}
