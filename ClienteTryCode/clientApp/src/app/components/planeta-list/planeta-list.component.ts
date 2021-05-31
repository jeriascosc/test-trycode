import { Component, OnInit } from '@angular/core';
import { PlanetasService } from '../../services/planetas.service';

@Component({
  selector: 'app-planeta-list',
  templateUrl: './planeta-list.component.html',
  styleUrls: ['./planeta-list.component.css']
})
export class PlanetaListComponent implements OnInit {
  planetas:any = [];
  constructor( private planetasService : PlanetasService ) { }

  ngOnInit(): void {
    this.getBasicAllPlanetas( );
  }

  getBasicAllPlanetas( ){
    this.planetasService.getBasicAllPlanetas( ).subscribe( 
      res => this.planetas = res,
      err => console.error( err )
    );
  }

}
