package com.salesianostriana.dam.ejemploluismi_conectarbddhibernate.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Data
@Table(name ="alumnado")
public class Alumno {

	@Id @GeneratedValue //Esto hace que la id se genere sola en la BDD, se deja asi que por defecto usa el AUTO
	private long id;
	
	@Column(columnDefinition = "VARCHAR(100)")
	private String nombre;
	private String apellidos;
	//@Column(updatable = false) /*Por si queremos que no se pueda modificar*/
	//Hacer
	private String email;
	private Curso curso;
	
	public Alumno(String nombre, String apellidos, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
	}

	
}
