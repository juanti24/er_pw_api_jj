package com.uce.edu.demo.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "profesor")
public class Profesor {
	
	@Id
	@Column(name = "prof_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_prof")
	@SequenceGenerator(name = "seq_prof", sequenceName = "seq_prof", allocationSize = 1)
	private Integer id;
	
	@Column(name = "prof_nombre")
	private String nombre;
	
	@Column(name = "prof_apellido")
	private String apellido;
	
	@Column(name = "prof_cedula")
	private String cedula;
	
	@Column(name = "prof_fecha_nacimiento")
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
