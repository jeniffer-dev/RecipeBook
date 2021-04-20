import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatGridListModule } from '@angular/material/grid-list'
import { MatInputModule} from '@angular/material/input';
import { MainNavComponent } from './main-nav/main-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { RecipesComponent } from './recipes/recipes.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatCardModule} from '@angular/material/card';
import { RecipeListComponent } from './recipes/recipe-list/recipe-list.component';
import { RecipeEditComponent } from './recipes/recipe-edit/recipe-edit.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RecipeDetailComponent } from './recipes/recipe-detail/recipe-detail.component';
import { RecipeItemComponent } from './recipes/recipe-list/recipe-item/recipe-item.component';
import { MatDividerModule } from '@angular/material/divider';


@NgModule({
  declarations: [
    AppComponent,
    MainNavComponent,
    RecipesComponent,
    RecipeListComponent,
    RecipeEditComponent,
    RecipeDetailComponent,
    RecipeItemComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    LayoutModule,
    ReactiveFormsModule,
    MatGridListModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    FlexLayoutModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatDividerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
