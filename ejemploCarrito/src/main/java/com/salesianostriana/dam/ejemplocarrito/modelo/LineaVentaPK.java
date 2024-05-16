package com.salesianostriana.dam.ejemplocarrito.modelo;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor @AllArgsConstructor
public class LineaVentaPK {

	private Long id;
	private Venta venta;
}
