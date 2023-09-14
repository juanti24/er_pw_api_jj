package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Profesor;
import com.uce.edu.demo.service.to.ProfesorTo;

public interface IProfesorService {

	public void guardar(Profesor prof);
	public void guardarTO(ProfesorTo profTO);
	public void modificar(Profesor prof);
    public Profesor consultarporId(Integer id);
    public void borrar(Integer id);
    public void borrarporCedula(String cedula);

    public List<ProfesorTo> buscarTodas();
    public ProfesorTo consultarporCedulaTO(String cedula);
    public Profesor consultarporCedula(String cedula);
}
