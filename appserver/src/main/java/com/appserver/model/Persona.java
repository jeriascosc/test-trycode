package com.appserver.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personas")
public class Persona {
	@Id 
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Integer idPersona;
	@Column
	private String nombrePersona;
	private String apellidoPersona;
	private Integer edadPersona;
	private Double alturaPersona;
	private Double pesoPersona;
	private String generoPersona;
	private Date fechaNacimientoPersona;
	private Integer countViewsPersona;
	private Integer idPlaneta;
	
	public Persona( ) {
		
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getApellidoPersona() {
		return apellidoPersona;
	}

	public void setApellidoPersona(String apellidoPersona) {
		this.apellidoPersona = apellidoPersona;
	}

	public Integer getEdadPersona() {
		return edadPersona;
	}

	public void setEdadPersona(Integer edadPersona) {
		this.edadPersona = edadPersona;
	}

	public Double getAlturaPersona() {
		return alturaPersona;
	}

	public void setAlturaPersona(Double alturaPersona) {
		this.alturaPersona = alturaPersona;
	}

	public Double getPesoPersona() {
		return pesoPersona;
	}

	public void setPesoPersona(Double pesoPersona) {
		this.pesoPersona = pesoPersona;
	}

	public String getGeneroPersona() {
		return generoPersona;
	}

	public void setGeneroPersona(String generoPersona) {
		this.generoPersona = generoPersona;
	}

	public Date getFechaNacimientoPersona() {
		return fechaNacimientoPersona;
	}

	public void setFechaNacimientoPersona(Date fechaNacimientoPersona) {
		this.fechaNacimientoPersona = fechaNacimientoPersona;
	}

	public Integer getCountViewsPersona() {
		return countViewsPersona;
	}

	public void setCountViewsPersona(Integer countViewsPersona) {
		this.countViewsPersona = countViewsPersona;
	}

	public Integer getIdPlaneta() {
		return idPlaneta;
	}

	public void setIdPlaneta(Integer idPlaneta) {
		this.idPlaneta = idPlaneta;
	}

	

	

	
	

	

	
	
}
