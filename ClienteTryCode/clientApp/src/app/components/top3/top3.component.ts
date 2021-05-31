import { Component, OnInit } from '@angular/core';
import { PlanetasService } from '../../services/planetas.service';

@Component({
  selector: 'app-top3',
  templateUrl: './top3.component.html',
  styleUrls: ['./top3.component.css']
})
export class Top3Component implements OnInit {

  listtop3:any = [];
  constructor( private planetasService : PlanetasService ) { }

  ngOnInit(): void {
    this.getTop3Planetas( );
  }

  getTop3Planetas( ){
    this.planetasService.getListTop3Planetas( ).subscribe( 
      res => this.listtop3 = res,
      err => console.error( err )
    );
  }

}
