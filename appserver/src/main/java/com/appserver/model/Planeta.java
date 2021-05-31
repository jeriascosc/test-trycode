package com.appserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="planetas")
public class Planeta {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Integer idPlaneta;
	@Column
	private String nombrePlaneta;
	@Column
	private Double periodoRotacionPlaneta;
	@Column 
	private Double diametroPlaneta;
	@Column 
	private Double climaPlaneta;
	@Column
	private String terrenoPlaneta;
	@Column 
	private Integer countViewsPlaneta;

	
	
	
	public Planeta( ) {
		
	}




	public Integer getIdPlaneta() {
		return idPlaneta;
	}




	public void setIdPlaneta(Integer idPlaneta) {
		this.idPlaneta = idPlaneta;
	}




	public String getNombrePlaneta() {
		return nombrePlaneta;
	}




	public void setNombrePlaneta(String nombrePlaneta) {
		this.nombrePlaneta = nombrePlaneta;
	}




	public Double getPeriodoRotacionPlaneta() {
		return periodoRotacionPlaneta;
	}




	public void setPeriodoRotacionPlaneta(Double periodoRotacionPlaneta) {
		this.periodoRotacionPlaneta = periodoRotacionPlaneta;
	}




	public Double getDiametroPlaneta() {
		return diametroPlaneta;
	}




	public void setDiametroPlaneta(Double diametroPlaneta) {
		this.diametroPlaneta = diametroPlaneta;
	}




	public Double getClimaPlaneta() {
		return climaPlaneta;
	}




	public void setClimaPlaneta(Double climaPlaneta) {
		this.climaPlaneta = climaPlaneta;
	}




	public String getTerrenoPlaneta() {
		return terrenoPlaneta;
	}




	public void setTerrenoPlaneta(String terrenoPlaneta) {
		this.terrenoPlaneta = terrenoPlaneta;
	}




	public Integer getCountViewsPlaneta() {
		return countViewsPlaneta;
	}




	public void setCountViewsPlaneta(Integer countViewsPlaneta) {
		this.countViewsPlaneta = countViewsPlaneta;
	}



	
	
	
}
