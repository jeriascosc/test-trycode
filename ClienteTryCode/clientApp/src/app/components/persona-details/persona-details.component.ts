import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { PersonasService } from '../../services/personas.service';
import { PlanetasService } from '../../services/planetas.service';
import { Persona } from '../model/Persona';

@Component({
  selector: 'app-persona-details',
  templateUrl: './persona-details.component.html',
  styleUrls: ['./persona-details.component.css']
})
export class PersonaDetailsComponent implements OnInit {
  id:any = '';
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
  constructor( private personasService: PersonasService, private route: ActivatedRoute, private planetasService: PlanetasService  ) { }
  
  ngOnInit(): void {
     this.id = this.route.snapshot.paramMap.get('id');
     this.getPersonaDetail( this.id );
  }

  getPersonaDetail( id: any ){
    this.personasService.getPersonaDetail( id ).subscribe(
      res => { if( res ){
                   this.persona = res; 
                   this.planetasService.getPlanetaDetail( this.persona.idPlaneta ).subscribe( );
               } 
     },
      err => console.error( err )
    );
  }

}
