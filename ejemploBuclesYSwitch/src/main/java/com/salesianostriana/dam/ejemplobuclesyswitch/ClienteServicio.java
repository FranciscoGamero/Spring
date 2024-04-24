package com.salesianostriana.dam.ejemplobuclesyswitch;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

//Anotamos la clase servicio
@Service
public class ClienteServicio {
	
	/*
	 * De nuevo, un método que nos provee una lista de clientes
	 * simulando que vienen de la base de datosd
	 * */
	public List<Cliente> getLista() {
		return Arrays.asList(
				new Cliente(1, "Ángel", "Naranjo", "González", "male"),
				new Cliente(2, "Luismi", "López", "Magaña", "male"),
				new Cliente(3, "Novia de ", "Doraemon", "No sé", "female"),
				new Cliente(4, "Corona", "Virus", "A", " ")
				);		
	}

}