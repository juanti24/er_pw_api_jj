package com.uce.edu.demo.repository;

import java.util.List;


import com.uce.edu.demo.repository.modelo.Profesor;

public interface IProfesorRepository {

	
	public void insertar(Profesor prof );
    public void actualizar(Profesor prof);
    public Profesor buscarporId(Integer id);
    public void eliminar(Integer id);
    
    public void eliminarporCedula(String cedula);
    public List<Profesor> buscarTodas();
	public Profesor buscarporCedula(String cedula);
}
