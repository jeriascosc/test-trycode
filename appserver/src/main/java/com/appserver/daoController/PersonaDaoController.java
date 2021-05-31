package com.appserver.daoController;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appserver.model.Persona;
/*
Clase controlador de la entidad Persona.
@Autor: Edwin Riascos
@Fecha: 27-05-2021
*/

public interface PersonaDaoController extends JpaRepository<Persona, Integer> {
	
	/*
	Metodo abstracto para obtener todos los registros de la tabla persona con todos sus respectivos campos incluidos los campos del planeta al que pertenece.
	@Autor: Edwin Riascos
	@Fecha: 27-05-2021
	*/
	@Query( value = "SELECT personas.ID_PERSONA, personas.NOMBRE_PERSONA, personas.APELLIDO_PERSONA, personas.COUNT_VIEWS_PERSONA, planetas.NOMBRE_PLANETA  FROM personas LEFT JOIN planetas  ON personas.ID_PLANETA = planetas.ID_PLANETA ", nativeQuery = true )
	public abstract List<Object> getPersonaAll(  );
	/*
	Metodo abstracto para obtener listado de registro de la tabla personas filtrados por idplaneta.
	@Autor: Edwin Riascos
	@Fecha: 27-05-2021
	*/
	@Query(value= "SELECT * FROM PERSONAS  WHERE ID_PLANETA = :idplaneta",  nativeQuery = true )
	public abstract List<Persona> getListPersonaByIdPlaneta( @Param( "idplaneta" ) Integer idplaneta );
}
