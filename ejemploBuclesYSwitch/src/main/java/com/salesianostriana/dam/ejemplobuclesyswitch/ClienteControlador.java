package com.salesianostriana.dam.ejemplobuclesyswitch;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteControlador {
	
	/*
	 * De nuevo, necesitamos un objeto del tipo CustomerService para poder llamar
	 * a los métodos de cicha clase, por lo que lo inyectamos aquí
	 * mediante @Autowired 
	 * */
	
	@Autowired
	private ClienteServicio service;
	
	//Nuevamente anotamos con el tipo de petición que atenderá este método (tipo get) 
	//cuando se escriba la ruta localhost:9000/listGen
	
	@GetMapping("/listGen")
	public String listarVarios (Model model) {
			
		/*
		 * Agregamos la lista al modelo usando el método del servicio
		 * y cuidando el nombre de la lista que usaremos en el html
		*/
		
		model.addAttribute("listaCliente", service.getLista());		
		return "PlantillaSwitch";
	}
	
}