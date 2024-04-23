package com.salesianostriana.dam.ejemploluismi_eramiprimeritodia2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
@Primary
public class SpanishSaludator implements Saludator{

	@Override
	public void imprimirSaludo() {
		// TODO Auto-generated method stub
		System.out.println("Hola a todos los programadores de 1ºDAM");
	}
}
