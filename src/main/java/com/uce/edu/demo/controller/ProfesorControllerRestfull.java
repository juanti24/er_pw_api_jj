package com.uce.edu.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.service.IProfesorService;
import com.uce.edu.demo.service.to.ProfesorTo;

@RequestMapping("/profesores")
@CrossOrigin()
@RestController
public class ProfesorControllerRestfull {
	
	
	@Autowired
	private IProfesorService ips;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void crearMateria(@RequestBody ProfesorTo profTo) {

		this.ips.guardarTO(profTo);

	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProfesorTo> listarMaterias(){
		List<ProfesorTo> listaMAterias= this.ips.buscarTodas();

		for (ProfesorTo p : listaMAterias) {
		Link myLink=linkTo( methodOn(ProfesorControllerRestfull.class).consultarProfesor(p.getCedula())).withSelfRel();
			p.add(myLink);
			System.out.println("profesor:  "+p.getNombre());
		}
		return listaMAterias;
	}

	@GetMapping(path = "/Completa", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfesorTo consultarProfesor(@RequestParam String cedula) {

		return this.ips.consultarporCedulaTO(cedula);
	}
	
	@DeleteMapping
	public void eliminarProfesor(@RequestParam String cedula) {
		this.ips.borrarporCedula(cedula);
	}

}
