import { RecipeIngredient } from "./recipeIngredient.model";

export class Recipe {
  public id: number;
  public name: string;
  public imageUrl: string;
  public cookTime: number;
  public preparationTime: number;
  public recipeIngredients: RecipeIngredient[];


  constructor(name: string, imageUrl: string, cookTime: number, preparationTime: number, recipeIngredients: RecipeIngredient[]){
    // this.id = id;
    this.name = name;
    this.imageUrl = imageUrl;
    this.cookTime = cookTime;
    this.preparationTime = preparationTime;
    this.recipeIngredients = recipeIngredients;
  }
}
