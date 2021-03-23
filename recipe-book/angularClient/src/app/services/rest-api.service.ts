import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { RecipeService } from "./recipe.service";
import { Recipe } from "../model/recipe.model";

@Injectable({providedIn: 'root'})
export class DataStorageService {
  apiUrl = 'http://localhost:8080/api/v1';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient, private recipeService: RecipeService) {}

  fetchRecipes(){
    this.http.get<Recipe[]>(this.apiUrl + '/recipes').subscribe(data => {
      this.recipeService.setRecipes(data);
    });
  }

  fetchRecipeById(id: number) {
    return this.http.get<Recipe>(this.apiUrl + '/recipes/' + id);
  }

  createRecipe(recipe: Recipe)  {
    this.http.post<Recipe>(this.apiUrl + '/recipes', JSON.stringify(recipe), this.httpOptions)
      .subscribe(data => {});
  }

  updateRecipe(id, recipe) {
    this.http.put<Recipe>(this.apiUrl + '/recipes/' + id, JSON.stringify(recipe), this.httpOptions)
      .subscribe(data => {});
  }

  removeRecipe(id: number){
    return this.http.delete<Recipe>(this.apiUrl + '/recipes/' + id, this.httpOptions);
  }
}
