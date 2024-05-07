package com.salesianostriana.dam.ejemplocrud.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


public class Alumno {

	@Id	
	@GeneratedValue
	private long id;
	
	private String nombre;
	private String apellidos;
	private String email;
}
