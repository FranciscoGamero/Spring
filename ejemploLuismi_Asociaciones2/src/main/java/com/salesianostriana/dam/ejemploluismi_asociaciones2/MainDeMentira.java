package com.salesianostriana.dam.ejemploluismi_asociaciones2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.ejemploluismi_asociaciones2.model.Asiento;
import com.salesianostriana.dam.ejemploluismi_asociaciones2.model.Avion;
import com.salesianostriana.dam.ejemploluismi_asociaciones2.model.TipoAsiento;
import com.salesianostriana.dam.ejemploluismi_asociaciones2.repository.AvionRepository;

@Component
public class MainDeMentira {

	@Autowired
	private AvionRepository avionRepo;
	
	void ejecutar() {
		Avion airbus320 = Avion.builder()
				.modelo("Airbus A320")
				.maxPasajeros(300)
				.build();
		
		for(int i = 1; i<=2;i++) {
			for(int j = 1; j<=6; j++) {
				airbus320.addAsiento(
						Asiento.builder()
						.tipo(TipoAsiento.PRIMERA)
						.fila(i)
						.columna(j)
						.build()						
						);
			}
		}
		
		for(int i = 3; i<=50;i++) {
			for(int j = 1; j<=6; j++) {
				airbus320.addAsiento(
						Asiento.builder()
						.tipo(TipoAsiento.TURISTA)
						.fila(i)
						.columna(j)
						.build()						
						);
			}
		}
		
		avionRepo.save(airbus320);
	}
}
