import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PlanetasService } from '../../services/planetas.service';
import { PersonasService } from '../../services/personas.service';
import { Persona } from '../model/Persona'; 



@Component({
  selector: 'app-persona-form',
  templateUrl: './persona-form.component.html',
  styleUrls: ['./persona-form.component.css']
})
export class PersonaFormComponent implements OnInit {
  
  listPlanetas:any = [ ];
  persona: Persona = { 
    idPersona: 0
  , nombrePersona: ''
  , apellidoPersona: ''
  , edadPersona: 0.0
  , alturaPersona: 0.0
  , pesoPersona: 0.0
  , generoPersona: 0.0
  , fechaNacimientoPersona: ''
  , idPlaneta: 0
  , countViewsPersona : 0
};
  constructor( private planetasService: PlanetasService, private personasService: PersonasService, private router: Router ) { }

  ngOnInit(): void {
    this.getListPlanetas( );
  }
  
  getListPlanetas( ){
    this.planetasService.getPlanetas( ).subscribe( 
      res => this.listPlanetas = res,
      err => console.error( err )
    );
  }

  saveNewPersona( ){
    this.personasService.savePersona( this.persona ).subscribe( 
       err => {
         if( !err ){
           this.router.navigate(['/personas']);
         }
       } 
     ); 
  }

}
