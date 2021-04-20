import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Recipe } from 'src/app/model/recipe.model';
import { DataStorageService } from 'src/app/services/rest-api.service';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {
  recipes: Recipe[];
  subscription: Subscription;

  constructor(private dataStorageService: DataStorageService) { }

  ngOnInit(): void {
    this.dataStorageService.fetchRecipes().subscribe(data => {
      this.recipes = data;
    });
  }


  onRemove(id: number) {
    this.dataStorageService.removeRecipe(id);
    console.log(id);
  }

}
