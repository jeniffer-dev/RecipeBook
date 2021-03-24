import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main-nav',
  templateUrl: './main-nav.component.html',
  styleUrls: ['./main-nav.component.css']
})
export class MainNavComponent {

  constructor(private router: Router) {}

  onNewRecipe() {
    this.router.navigate(['/new']);
  }

  onRecipes() {
    this.router.navigate(['/recipes']);
  }

}
