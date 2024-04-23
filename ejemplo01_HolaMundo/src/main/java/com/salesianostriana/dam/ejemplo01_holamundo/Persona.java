package com.salesianostriana.dam.ejemplo01_holamundo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data /*Establece los getter and setters y derivados*/
@AllArgsConstructor /*Añade todos los constructores*/
@NoArgsConstructor /*Añade el constructor vacio*/
public class Persona {

	private String nombre;
	private String apellidos;
	
}
