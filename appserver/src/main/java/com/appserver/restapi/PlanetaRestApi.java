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

import com.appserver.daoController.PlanetaDaoController;
import com.appserver.model.Persona;
import com.appserver.model.Planeta;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping( "v1/planeta" )
public class PlanetaRestApi {
	@Autowired
	private PlanetaDaoController ctrlPlanetaDao;
	
	/*
	Función para obtener todos los registros de la tabla planeta por medio del metodo HTTP get
	@Autor: Edwin Riascos
	@Fecha: 27-05-2021
	*/
	@GetMapping( "/showall" )
	public List<Object> showAllPlaneta( ){
		return ctrlPlanetaDao.findAllInfoBasicPlaneta( ) != null ? ctrlPlanetaDao.findAllInfoBasicPlaneta( ) : null ;
	}
	/*
	Función para crear un registro en tabla planeta por medio del metodo HTTP post. Esta función recibe un 
	objeto Persona cateado a un objeto Json con el uso de la anotación @RequestBody
	@Autor: Edwin Riascos
	@Fecha: 27-05-2021
	*/
	@PostMapping( "/save" )
	public void createPlaneta( @RequestBody Planeta planeta ) {
		this.ctrlPlanetaDao.save( planeta );
	}
	/*
	Función para eliminar un registro de la tabla planeta por medio del metodo HTTP delete
	@Autor: Edwin Riascos
	@Fecha: 27-05-2021
	*/
	@DeleteMapping("/delete/{id}")
	public void deletePlanetaById( @PathVariable("id") Integer id ) {
		this.ctrlPlanetaDao.deleteById( id );
	}
	/*
	Función para actualizar un registro en la tabla persona por medio del metodo HTTP put. Esta función recibe un 
	objeto Persona cateado a un objeto Json con el uso de la anotación @RequestBody
	@Autor: Edwin Riascos
	@Fecha: 27-05-2021
	*/
	@PutMapping( "/update" )
	public void updatePersona( @RequestBody Planeta planeta ) {
		this.ctrlPlanetaDao.save( planeta );
	}
	/*
	Función para acceder al detalle planeta y al mismo tiempo incrementar el campo contador vista de la tabla planeta 
	@Autor: Edwin Riascos
	@Fecha: 29-05-2021
	*/	
	@GetMapping( "/details/{id}" )
	public Planeta DetailsPlaneta(@PathVariable( "id" ) Integer id ){
		Optional<Planeta> dataFindedPlaneta = this.ctrlPlanetaDao.findById( id );
		Planeta planeta = new Planeta( );
		if( dataFindedPlaneta.get().getIdPlaneta() > 0 ) {
			int countVistaPlaneta = ( dataFindedPlaneta.get().getCountViewsPlaneta() )+1;
			planeta.setIdPlaneta( dataFindedPlaneta.get().getIdPlaneta() );
			planeta.setNombrePlaneta( dataFindedPlaneta.get().getNombrePlaneta() );
			planeta.setPeriodoRotacionPlaneta( dataFindedPlaneta.get().getPeriodoRotacionPlaneta() );
			planeta.setDiametroPlaneta( dataFindedPlaneta.get().getDiametroPlaneta() );
			planeta.setClimaPlaneta( dataFindedPlaneta.get().getClimaPlaneta() );
			planeta.setTerrenoPlaneta( dataFindedPlaneta.get().getTerrenoPlaneta() );
			planeta.setCountViewsPlaneta( countVistaPlaneta );
			this.ctrlPlanetaDao.save( planeta );
		}
		return planeta != null ? planeta : null ;
	}
	/*
	Función para obtener el top 3 de los planetas mas visitados.
	@Autor: Edwin Riascos
	@Fecha: 29-05-2021
	*/
   @GetMapping( "/top3" ) 
   public List<Planeta> getListTop3Planeta( ){
	   return this.ctrlPlanetaDao.getListTop3Planetas( );
   }
	
}
