import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Persona } from '../components/model/Persona';

@Injectable({
  providedIn: 'root'
})
export class PersonasService {

  constructor( private http: HttpClient ) { 

  }
   URI_RESTAPI_PERSONA = 'http://127.0.0.1:8080/v1/persona'; 
  /*
	Metodo service para obtener informacion basica de los registros de la tabla personas
	@Autor: Edwin Riascos
	@Fecha: 29-05-2021
	*/
  getListPersonas( ){
    return this.http.get( `${this.URI_RESTAPI_PERSONA}/showall`);
  }
  /*
	Metodo service para obtener informacion detallada de un registro específico de la tabla personas
	@Autor: Edwin Riascos
	@Fecha: 29-05-2021
	*/
  getPersonaDetail(  id:string | any ){
    return this.http.get( `${this.URI_RESTAPI_PERSONA}/viewdetails/${id}` );
  }
  /*
	Metodo service para guardar un registro en la tabla personas.
	@Autor: Edwin Riascos
	@Fecha: 29-05-2021
	*/
  savePersona( persona : Persona ){
    return this.http.post( `${this.URI_RESTAPI_PERSONA}/save`, persona );
  }
  /*
	Metodo service para eloiminar un registro en la tabla personas.
	@Autor: Edwin Riascos
	@Fecha: 29-05-2021
	*/
  deletePersona( id : string ){
    return this.http.delete( `${this.URI_RESTAPI_PERSONA}/delete/${id}` );
  }
  /*
	Metodo service para actualizar un registro en la tabla personas.
	@Autor: Edwin Riascos
	@Fecha: 29-05-2021
	*/
  updatePersona( persona : Persona ){
    return this.http.put( `${this.URI_RESTAPI_PERSONA}/save`, persona );
  }
  /*
	Metodo service para obtener listado de personas por id planeta
	@Autor: Edwin Riascos
	@Fecha: 29-05-2021
	*/
  getListPersonasByIdPlaneta( id:string | any | number ){
    return this.http.get( `${this.URI_RESTAPI_PERSONA}/viewlite/${id}` );
  }

}
