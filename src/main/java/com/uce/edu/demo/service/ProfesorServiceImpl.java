package com.uce.edu.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProfesorRepository;
import com.uce.edu.demo.repository.modelo.Profesor;
import com.uce.edu.demo.service.to.ProfesorTo;

@Service
public class ProfesorServiceImpl implements IProfesorService{
	
	@Autowired
	private IProfesorRepository ipm;

	@Override
	public void guardar(Profesor prof) {
		this.ipm.insertar(prof);
		
	}

	@Override
	public void guardarTO(ProfesorTo profTO) {
		this.ipm.insertar(convertir(profTO));
		
	}

	@Override
	public void modificar(Profesor prof) {
		this.ipm.actualizar(prof);
		
	}

	@Override
	public Profesor consultarporId(Integer id) {
		// TODO Auto-generated method stub
		return this.ipm.buscarporId(id);
	}

	@Override
	public void borrar(Integer id) {
		this.ipm.eliminar(id);
		
	}

	@Override
	public void borrarporCedula(String cedula) {
		Profesor prof=this.ipm.buscarporCedula(cedula);
		this.borrar(prof.getId());
		
	}

	@Override
	public List<ProfesorTo> buscarTodas() {
		List<Profesor> lista = this.ipm.buscarTodas();

		return lista.stream().map(p -> this.convertirTo(p)).collect(Collectors.toList());
	}

	@Override
	public ProfesorTo consultarporCedulaTO(String cedula) {
		// TODO Auto-generated method stub
		return this.convertirTo(this.consultarporCedula(cedula));
	}

	@Override
	public Profesor consultarporCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.ipm.buscarporCedula(cedula);
	}

	public Profesor convertir(ProfesorTo profto) {
		Profesor prof = new Profesor();
		prof.setApellido(profto.getApellido());
		prof.setCedula(profto.getCedula());
		prof.setFechaNaciemiento(profto.getFechaNaciemiento());
		prof.setId(profto.getId());
		prof.setNombre(profto.getNombre());
		
		
		return prof;
		
	}
	
	public ProfesorTo convertirTo(Profesor prof) {
		ProfesorTo profTo = new ProfesorTo();
		profTo.setApellido(prof.getApellido());
		profTo.setCedula(prof.getCedula());
		profTo.setFechaNaciemiento(prof.getFechaNaciemiento());
		profTo.setId(prof.getId());
		profTo.setNombre(prof.getNombre());
		
		
		return profTo;
		
	}
	
	
}
