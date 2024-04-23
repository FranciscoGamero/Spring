package com.salesianostriana.dam.ejemploluismi_eramiprimeritodia2web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controlador {

	@Autowired
	private Saludator saludator; //Indicamos que tiene una dependencia de Saludator
	
	@GetMapping("/") //Está atento que en el navegador pongamos localhost:9000
	@ResponseBody // Lo que hace es devolver al navegador como respuesta lo que devuelva este método
	public String welcome() {
		
		return saludator.saludar();
	}
}
