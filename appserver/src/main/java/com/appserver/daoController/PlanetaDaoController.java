package com.appserver.daoController;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appserver.model.Planeta;

/*
Clase controlador de la entidad Planeta.
@Autor: Edwin Riascos
@Fecha: 27-05-2021
*/

public interface PlanetaDaoController extends JpaRepository<Planeta, Integer> {
	/*
	Metodo abstracto para obtener nombre y cantidad de persona de todos los registros de la tabla planeta 
	@Autor: Edwin Riascos
	@Fecha: 29-05-2021
	*/
	@Query( 
		  value = "SELECT "
		  		+ "         COUNT( PERSONAS.ID_PERSONA ) AS cantidadPersonas "
		  		+ "       , PLANETAS.ID_PLANETA "
		  		+ "       , PLANETAS.NOMBRE_PLANETA "
		  		+ "       , PLANETAS.COUNT_VIEWS_PLANETA "
		  		+ "FROM PLANETAS  LEFT JOIN PERSONAS "
		  		+ "       ON PLANETAS.ID_PLANETA = PERSONAS.ID_PLANETA "
		  		+ "GROUP BY PLANETAS.ID_PLANETA, PLANETAS.NOMBRE_PLANETA "
		  , nativeQuery = true 
		  )
	public abstract List<Object> findAllInfoBasicPlaneta();
	/*
	Metodo abstracto para obtener el top 3 de la tabla planeta con mas vistas 
	@Autor: Edwin Riascos
	@Fecha: 29-05-2021
	*/
	@Query( value = "SELECT * FROM PLANETAS   WHERE COUNT_VIEWS_PLANETA  > 0 ORDER BY COUNT_VIEWS_PLANETA DESC  LIMIT 3", nativeQuery = true )
	public List<Planeta> getListTop3Planetas( );
	
}
