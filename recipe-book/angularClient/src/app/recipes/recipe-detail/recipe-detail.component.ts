import { Component, OnChanges, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Recipe } from 'src/app/model/recipe.model';
import { DataStorageService } from 'src/app/services/rest-api.service';

@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css']
})
export class RecipeDetailComponent implements OnInit {
  recipeDetail: Recipe;
  id: number;

  constructor(private dataStorageService: DataStorageService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.route.params
    .subscribe(
      (params: Params) => {
        this.id = +params['id'];
        this.getRecipe(this.id);
      }
    );

  }

  getRecipe(id: number) {
    this.dataStorageService.fetchRecipeById(id).subscribe((recipe) => {
      this.recipeDetail = recipe;
    });
  }

  onRemove(){
    this.dataStorageService.removeRecipe(this.id).subscribe(data => {
      console.log(data);
      this.router.navigate(['/recipes']);
    });

  }

  onEditRecipe() {
    this.router.navigate(['edit'], {relativeTo: this.route});
  }

}
