package com.salesianostriana.dam.ejemploluismi_herenciamappedsuperclass2.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor @AllArgsConstructor
@Data
@SuperBuilder //Se usa superbuilder porque hay herencia
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class Bebida extends Producto{

	// Tamaño de la bebida expresado en centilitros
	private int tamanio;
}
