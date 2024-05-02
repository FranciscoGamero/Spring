package com.salesianostriana.dam.ejemploluismi_herenciamappedsuperclass2.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Data
@SuperBuilder //Se usa superbuilder porque hay herencia
public abstract class Producto {

	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	private float precio;
}
