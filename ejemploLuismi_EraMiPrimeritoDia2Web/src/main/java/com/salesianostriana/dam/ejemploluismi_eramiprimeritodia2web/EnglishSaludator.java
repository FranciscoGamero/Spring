package com.salesianostriana.dam.ejemploluismi_eramiprimeritodia2web;

import org.springframework.stereotype.Service;

@Service
public class EnglishSaludator implements Saludator{
	
	public void imprimirSaludo() {
		System.out.println("Hello codders of 1º DAM");
	}

	@Override
	public String saludar() {
		// TODO Auto-generated method stub
		return "Hello codders of 1º DAM";
	}

}
