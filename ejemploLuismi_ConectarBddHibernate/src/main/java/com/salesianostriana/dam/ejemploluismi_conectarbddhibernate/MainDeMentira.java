package com.salesianostriana.dam.ejemploluismi_conectarbddhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.ejemploluismi_conectarbddhibernate.modelo.Alumno;
import com.salesianostriana.dam.ejemploluismi_conectarbddhibernate.respositorios.AlumnoRepository;

import jakarta.annotation.PostConstruct;

@Component
public class MainDeMentira {

	//Las clases que son Entidades no pueden inyectarse
	@Autowired
	private AlumnoRepository repositorio;
	
	@PostConstruct //Esto se ejecuta al arrancar el proyecto
	void ejecutar() {
		repositorio.save(new Alumno("Luis Miguel", "López Magaña", "luismi.lopez@triana.salesianos.edu"));
		
		//repositorio.findAll().forEach(a -> System.out.println(a));
		
		repositorio.findAll().forEach(System.out::println);
	}
}
