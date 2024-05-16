package com.salesianostriana.dam.ejemplocarrito.modelo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Venta {

	private Long id;
	
	//ManyToOne
	private Usuario usuario;
	
	//DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaPedido;
	
	private double importeTotal;
	
	private boolean finalizada;
	/*
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy="venta", 
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	*/
	private List<LineaVenta> lineasVenta;
	
	public void addLineaVenta(LineaVenta linea) {
		linea.setVenta(this);
		this.lineasVenta.add(linea);
	}
	
	public void removeLineaVenta(LineaVenta aEliminar) {
		this.lineasVenta.remove(aEliminar);
		aEliminar.setVenta(this);
	}
}
