package com.salesianostriana.dam.ejemploluismi_asociaciones2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asiento {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private int fila, columna;
	
	@Enumerated(EnumType.STRING)
	private TipoAsiento tipo;
	
	@ManyToOne
	private Avion avion;

}