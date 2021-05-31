package com.appserver.restapi;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appserver.daoController.PersonaDaoController;
import com.appserver.model.Persona;

/*
Clase para la gestión de los metodos HTTP de la entidad persona.
@Autor: Edwin Riascos
@Fecha: 27-05-2021
*/

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("v1/persona")
public class PersonaRestApi {
	@Autowired
	private PersonaDaoController ctrlPersonaDao;
	
	/*
	Función para obtener todos los registros de la union de tabla persona y planeta por medio del metodo HTTP get
	@Autor: Edwin Riascos
	@Fecha: 27-05-2021
	*/
	@GetMapping( "/showall" )
	public List<Object> showAllPersonas( ){
		return this.ctrlPersonaDao.getPersonaAll() != null ? this.ctrlPersonaDao.getPersonaAll() :  null;
	}
	/*
	Función para crear un registro en la tabla persona por medio del metodo HTTP post. Esta función recibe un 
	objeto Persona cateado a un objeto Json con el uso de la anotación @RequestBody
	@Autor: Edwin Riascos
	@Fecha: 27-05-2021
	*/
	@PostMapping( "/save" )
	public void createPersona( @RequestBody Persona persona ) {
		this.ctrlPersonaDao.save( persona );
	}
	/*
	Función para eliminar un registro de la tabla persona por medio del metodo HTTP delete
	@Autor: Edwin Riascos
	@Fecha: 27-05-2021
	*/
	@DeleteMapping("/delete/{id}")
	public void deletePersonaById( @PathVariable("id") Integer id ) {
		this.ctrlPersonaDao.deleteById( id );
	}
	/*
	Función para actualizar un registro en la tabla persona por medio del metodo HTTP put. Esta función recibe un 
	objeto Persona cateado a un objeto Json con el uso de la anotación @RequestBody
	@Autor: Edwin Riascos
	@Fecha: 27-05-2021
	*/
	@PutMapping( "/update" )
	public void updatePersona( @RequestBody Persona persona ) {
		this.ctrlPersonaDao.save( persona );
	}
	/*
	Función para acceder al detalle persona y al mismo tiempo incrementar el campo contador vista de la tabla persona y la tabla planeta
	@Autor: Edwin Riascos
	@Fecha: 27-05-2021
	*/
	@GetMapping( "/viewdetails/{id}" )
	public Persona getViewDetailPersona( @PathVariable( "id" ) Integer id ){
		Optional<Persona> dataFindedPersona = this.ctrlPersonaDao.findById( id );
		Persona persona = new Persona( );
		if( dataFindedPersona.get().getIdPersona() > 0 ) { 
			int countVistaPersona = ( dataFindedPersona.get().getCountViewsPersona() )+1;
			persona.setIdPersona(id);
			persona.setNombrePersona( dataFindedPersona.get().getNombrePersona() );
			persona.setApellidoPersona( dataFindedPersona.get().getApellidoPersona()  );
			persona.setEdadPersona( dataFindedPersona.get().getEdadPersona() );
			persona.setAlturaPersona( dataFindedPersona.get().getAlturaPersona() );
			persona.setPesoPersona( dataFindedPersona.get().getPesoPersona() );
			persona.setGeneroPersona( dataFindedPersona.get().getGeneroPersona() );
			persona.setFechaNacimientoPersona( dataFindedPersona.get().getFechaNacimientoPersona() );
			persona.setCountViewsPersona( countVistaPersona );
			persona.setIdPlaneta( dataFindedPersona.get().getIdPlaneta() );
			this.ctrlPersonaDao.save( persona );
		}
		return persona != null ? persona : persona ;
	}
	/*
	Función para obtener los registros de la tabla persona filtrados por idplanta.
	@Autor: Edwin Riascos
	@Fecha: 29-05-2021
	*/
	@GetMapping( "/viewlite/{id}" )
	public List<Persona> getListPersonasByIdPlaneta( @PathVariable( "id" ) Integer idplaneta ){
		return this.ctrlPersonaDao.getListPersonaByIdPlaneta(idplaneta);
	}
	
}
