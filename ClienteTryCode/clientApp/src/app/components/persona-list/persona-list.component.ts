import { Component, OnInit } from '@angular/core';
import { PersonasService } from '../../services/personas.service';

@Component({
  selector: 'app-persona-list',
  templateUrl: './persona-list.component.html',
  styleUrls: ['./persona-list.component.css']
})
export class PersonaListComponent implements OnInit {
  personas:any = null;
  constructor( private personasService : PersonasService  ) { }

  ngOnInit(): void {
    this.getListPersonas( );
  }

  getListPersonas( ){
    this.personasService.getListPersonas( ).subscribe( 
      res => {
        this.personas = res;
      },
      err => console.error( err )
    );
  } 

  

}
