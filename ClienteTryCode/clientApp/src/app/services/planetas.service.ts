import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Planeta } from '../components/model/Planeta';

@Injectable({
  providedIn: 'root'
})
export class PlanetasService {

  constructor( private http: HttpClient ) { }

  URI_RESTAPI_PLANETA = 'http://127.0.0.1:8080/v1/planeta'; 
  /*
	Metodo service para obtener informacion basica de los registros de la tabla planetas
	@Autor: Edwin Riascos
	@Fecha: 29-05-2021
	*/
  getBasicAllPlanetas( ){
    return this.http.get( `${this.URI_RESTAPI_PLANETA}/showall` );
  }
  /*
	Metodo service para obtener informacion detallada de un registro específico de la tabla planeta
	@Autor: Edwin Riascos
	@Fecha: 29-05-2021
	*/
  getPlanetaDetail( id: string | any | number ){
    return this.http.get( `${this.URI_RESTAPI_PLANETA}/details/${id}` );
  }
  /*
	Metodo service para guardar un registro en la tabla planeta.
	@Autor: Edwin Riascos
	@Fecha: 29-05-2021
	*/
  savePlaneta( planeta : Planeta ){
    return this.http.post( `${this.URI_RESTAPI_PLANETA}/save`, planeta );
  }
  /*
	Metodo service para obtener el top 3 de planetas más visitados
	@Autor: Edwin Riascos
	@Fecha: 29-05-2021
	*/
  getListTop3Planetas( ){
    return this.http.get( `${this.URI_RESTAPI_PLANETA}/top3` );
  }

}
