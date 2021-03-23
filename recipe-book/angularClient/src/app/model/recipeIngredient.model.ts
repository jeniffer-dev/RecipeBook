import { Ingredient } from "./ingredient.model";

export class RecipeIngredient{
  constructor(public ingredient: Ingredient, public amount: number, public unit: string) {}
}
