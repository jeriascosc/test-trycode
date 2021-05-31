import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { PersonaFormComponent } from './components/persona-form/persona-form.component';
import { PlanetaFormComponent } from './components/planeta-form/planeta-form.component';
import { PersonaListComponent } from './components/persona-list/persona-list.component';
import { PlanetaListComponent } from './components/planeta-list/planeta-list.component';

import { PersonasService } from './services/personas.service';
import {  PlanetasService } from './services/planetas.service';
import { HttpClientModule } from '@angular/common/http';
import { PersonaDetailsComponent } from './components/persona-details/persona-details.component';
import { PlanetaDetailsComponent } from './components/planeta-details/planeta-details.component';
import { Top3Component } from './components/top3/top3.component';


@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    PersonaFormComponent,
    PlanetaFormComponent,
    PersonaListComponent,
    PlanetaListComponent,
    PersonaDetailsComponent,
    PlanetaDetailsComponent,
    Top3Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    PersonasService,
    PlanetasService    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
