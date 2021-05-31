import { Component, OnInit } from '@angular/core';
import { Planeta } from '../model/Planeta';
import { PlanetasService } from '../../services/planetas.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-planeta-form',
  templateUrl: './planeta-form.component.html',
  styleUrls: ['./planeta-form.component.css']
})
export class PlanetaFormComponent implements OnInit {
  planeta: Planeta = {
    idPlaneta: 0,
    nombrePlaneta: '',
    periodoRotacionPlaneta: 0.0,
    diametroPlaneta: 0.0,
    climaPlaneta: 0.0,
    terrenoPlaneta: '',
    countViewsPlaneta: 0,
  };
  constructor( private planetasService: PlanetasService, private router: Router  ) { }

  ngOnInit(): void {
   
  }

  saveNewPlaneta( ){
    this.planetasService.savePlaneta( this.planeta ).subscribe( 
      err => { 
        if( !err ){
            this.router.navigate(['/planetas']);
        }
      }
    );
  }


}
