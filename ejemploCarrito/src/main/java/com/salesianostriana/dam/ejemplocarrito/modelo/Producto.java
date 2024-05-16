package com.salesianostriana.dam.ejemplocarrito.modelo;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Producto {

	
	@Id
	@GeneratedValue
	private Long id;	
	private String nombre;
		
	@Lob 
	private String descripcion;	
	private float pvp;
	private float descuento;
	
	private String imagen;
	
	public double getPrecioFinal() {
		return pvp * (1-descuento);
	}
	public boolean tieneDescuento() {
		return (descuento>0);
	}
}
