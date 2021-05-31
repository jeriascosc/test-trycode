import { Component, OnInit } from '@angular/core';
import { PlanetasService } from '../../services/planetas.service';
import { PersonasService } from '../../services/personas.service';
import { Planeta } from '../model/Planeta';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-planeta-details',
  templateUrl: './planeta-details.component.html',
  styleUrls: ['./planeta-details.component.css']
})
export class PlanetaDetailsComponent implements OnInit {
  id: any = '';
  planeta: Planeta = {
    idPlaneta: 0,
    nombrePlaneta: '',
    periodoRotacionPlaneta: 0.0,
    diametroPlaneta: 0.0,
    climaPlaneta: 0.0,
    terrenoPlaneta: '',
    countViewsPlaneta: 0,
  };

  listPersonasPlaneta: any = [];

  constructor(private planetasService: PlanetasService, private route: ActivatedRoute, private personasService: PersonasService) {

  }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this. getPlanetaDetail( this.id );
  }
  getPlanetaDetail( id: any ){
    this.planetasService.getPlanetaDetail( id ).subscribe(
      res => {
        if (res) {
          this.planeta = res;
          this.personasService.getListPersonasByIdPlaneta( this.planeta.idPlaneta ).subscribe(
            res => this.listPersonasPlaneta = res
          );
        }

      },
      err => console.error(err)
    );
  }


}
