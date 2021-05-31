import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PersonaListComponent } from './components/persona-list/persona-list.component';
import { PersonaDetailsComponent } from './components/persona-details/persona-details.component';
import { PlanetaListComponent } from './components/planeta-list/planeta-list.component';
import { PlanetaDetailsComponent } from './components/planeta-details/planeta-details.component';
import { Top3Component } from './components/top3/top3.component';
import { PlanetaFormComponent } from './components/planeta-form/planeta-form.component';
import { PersonaFormComponent } from './components/persona-form/persona-form.component';

const routes: Routes = [
  { path: '', redirectTo: '/personas', pathMatch: 'full' } ,
  { path: 'personas', component: PersonaListComponent },
  { path: 'persona/detail/:id', component: PersonaDetailsComponent },
  { path: 'planetas', component: PlanetaListComponent  },
  { path: 'planetas/detail/:id', component:PlanetaDetailsComponent },
  { path: 'top3', component: Top3Component },
  { path: 'planeta/save', component: PlanetaFormComponent },
  { path: 'persona/save', component: PersonaFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
