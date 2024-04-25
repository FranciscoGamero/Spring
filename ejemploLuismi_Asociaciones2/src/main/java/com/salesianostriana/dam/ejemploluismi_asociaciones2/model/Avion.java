package com.salesianostriana.dam.ejemploluismi_asociaciones2.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Avion {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String modelo;
	
	private int maxPasajeros;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@Builder.Default
	@OneToMany(
			mappedBy="avion", 
			fetch = FetchType.EAGER,
			cascade = CascadeType.ALL, //Que las operaciones que se hagan sobre el avion tmb se hagan sobre los asientos
			orphanRemoval = true //
	)
	private List<Asiento> asientos = new ArrayList<>();

	
	// MÉTODOS HELPER Que permite guardar los asientos en el avion
	// Esto es en este caso ya que no va a haber un repositorio de los Asientos
	
	public void addAsiento(Asiento a) {
		a.setAvion(this);
		this.asientos.add(a);
	}
	
	public void removeAsiento(Asiento a) {
		this.asientos.remove(a);
		a.setAvion(null);
		
	}
	
}
