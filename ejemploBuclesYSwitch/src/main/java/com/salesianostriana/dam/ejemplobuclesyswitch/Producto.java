package com.salesianostriana.dam.ejemplobuclesyswitch;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

	private long id;
	private String nombre;
	private String descripcion;
	private double precio;
	private boolean enStock;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime fecha;
}
