package com.uce.edu.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Profesor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProfesorRepositoryImpl implements IProfesorRepository {
	
	@Autowired
	private EntityManager em;
	

	@Override
	public void insertar(Profesor prof) {
		this.em.persist(prof);
		
	}

	@Override
	public void actualizar(Profesor prof) {
		this.em.merge(prof);

		
	}

	@Override
	public Profesor buscarporId(Integer id) {
		TypedQuery<Profesor> myquery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.id  =: datoId",
				Profesor.class);
		myquery.setParameter("datoId", id);
		return myquery.getSingleResult();
	}

	@Override
	public void eliminar(Integer id) {
		this.em.remove(id);
		
	}

	@Override
	public void eliminarporCedula(String cedula) {
		this.em.remove(cedula);
		
	}

	@Override
	public List<Profesor> buscarTodas() {
		TypedQuery<Profesor> myquery = this.em.createQuery("SELECT p FROM Profesor p", Profesor.class);
		return myquery.getResultList();
	}

	@Override
	public Profesor buscarporCedula(String cedula) {
		TypedQuery<Profesor> myQuery = this.em.createQuery("SELECT p FROM Profesor p WHERE p.cedula =: datoCodigo",
				Profesor.class);
		myQuery.setParameter("datoCodigo", cedula);
		return myQuery.getSingleResult();
	}

}
