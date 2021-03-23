import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormArray, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Ingredient } from 'src/app/model/ingredient.model';
import { Recipe } from 'src/app/model/recipe.model';
import { RecipeIngredient } from 'src/app/model/recipeIngredient.model';
import { RecipeService } from 'src/app/services/recipe.service';
import { DataStorageService } from 'src/app/services/rest-api.service';

@Component({
  selector: 'app-recipe-edit',
  templateUrl: './recipe-edit.component.html',
  styleUrls: ['./recipe-edit.component.css']
})
export class RecipeEditComponent implements OnInit {
  id: number = 84;
  editMode = true;
  recipeForm: FormGroup;
  recipe: Recipe;

  constructor(private dataStorageService: DataStorageService,
    private recipeService: RecipeService,
    private router: Router) { }

    ngOnInit(): void {
      this.initForm();
    }

    private initForm() {
      let name = '';
      let imageUrl = '';
      let cookTime = 0;
      let preparationTime = 0;
      let recipeIngredients = new FormArray([]);

      if (this.editMode) {
        this.dataStorageService.fetchRecipeById(84).subscribe( recipe => {
          this.recipeForm = new FormGroup({
            'name': new FormControl(recipe.name, Validators.required),
            'imageUrl': new FormControl(recipe.imageUrl, Validators.required),
            'cookTime': new FormControl(recipe.cookTime, Validators.required),
            'preparationTime': new FormControl(recipe.preparationTime, Validators.required),
            'recipeIngredients': recipeIngredients
          });
          if(recipe['recipeIngredients']) {
            for (let ingredient of recipe.recipeIngredients) {
              recipeIngredients.push(
                new FormGroup({
                  'name': new FormControl(ingredient.ingredient.name, Validators.required),
                  'amount': new FormControl(ingredient.amount, [Validators.required,
                    Validators.pattern(/^[1-9]+[0-9]*$/)]),
                    'unit': new FormControl(ingredient.unit, Validators.required)
                  })
                );
              }
            }
          });
        }

        this.recipeForm = new FormGroup({
          'name': new FormControl(name, Validators.required),
          'imageUrl': new FormControl(imageUrl, Validators.required),
          'cookTime': new FormControl(cookTime, Validators.required),
          'preparationTime': new FormControl(preparationTime, Validators.required),
          'recipeIngredients': recipeIngredients
        });
      }

      onAddIngredient() {
        (<FormArray>this.recipeForm.get('recipeIngredients')).push(
          new FormGroup({
            'name': new FormControl(null, Validators.required),
            'amount': new FormControl(null, [
              Validators.required,
              Validators.pattern(/^[1-9]+[0-9]*$/),
            ]),
            'unit': new FormControl(null)
          })
        );
      }


      onSubmit() {
        if (this.editMode) {
          this.dataStorageService.updateRecipe(this.id, this.createRecipe())
        } else {
          this.dataStorageService.createRecipe(this.createRecipe());
        }
      }

      private createRecipe(): Recipe {
        var recipeIngredredients: RecipeIngredient[] = [];
        this.recipeForm.value.recipeIngredients.forEach(recipeIngredient => {
          const ingredient: Ingredient = new Ingredient(recipeIngredient.name)
          const recipeIng: RecipeIngredient = new RecipeIngredient(ingredient, recipeIngredient.amount, recipeIngredient.unit)
          recipeIngredredients.push(recipeIng)
        });
        const recipe: Recipe = new Recipe(
          this.recipeForm.value.name,
          this.recipeForm.value.imageUrl,
          this.recipeForm.value.cookTime,
          this.recipeForm.value.preparationTime,
          recipeIngredredients
        );
        return recipe;
      }

      get controls(){
        return (this.recipeForm.get('recipeIngredients') as FormArray).controls;
      }
    }
