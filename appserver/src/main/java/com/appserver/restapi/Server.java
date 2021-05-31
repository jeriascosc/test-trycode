package com.appserver.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.appserver.daoController.PersonaDaoController;
import com.appserver.daoController.PlanetaDaoController;

@RestController
public class Server {
	@Autowired
	private PersonaDaoController ctrlPersonaDao;
	private PlanetaDaoController ctrlPlanetaDao;
	public Server( ) {
		
	}
	
}
