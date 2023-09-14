package com.uce.edu.demo.service.to;

import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

public class ProfesorTo extends RepresentationModel<ProfesorTo>{
	
	
	private Integer id;
	
	
	private String nombre;
	
	
	private String apellido;
	
	
	private String cedula;
	
	
	private LocalDateTime fechaNaciemiento;


	public Integer getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public String getCedula() {
		return cedula;
	}


	public LocalDateTime getFechaNaciemiento() {
		return fechaNaciemiento;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public void setFechaNaciemiento(LocalDateTime fechaNaciemiento) {
		this.fechaNaciemiento = fechaNaciemiento;
	}
	
	

}
