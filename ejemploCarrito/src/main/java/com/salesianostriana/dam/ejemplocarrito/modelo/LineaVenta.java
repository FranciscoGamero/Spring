package com.salesianostriana.dam.ejemplocarrito.modelo;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class LineaVenta {

	private Long id;
	
	private Venta venta;
	private Producto producto;
	private int cantidad;
	
	public double getPrecioLineaVenta() {
		return producto.getPvp() * cantidad;
	}
}
