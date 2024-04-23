package com.salesianostriana.dam.ejemploluismi_eramiprimeritodia2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
//@RequiredArgsConstructor Se pueden hacer autoinyecciones con esto, que lo agrega Lombok
public class MainDeMentira {

	@Autowired
	@Qualifier("englishSaludator") //Nombre de la clase pero como si fuera una variable
	private Saludator saludator;
	
	@PostConstruct
	public void run() {
		
		saludator.imprimirSaludo();
		
	}
}
