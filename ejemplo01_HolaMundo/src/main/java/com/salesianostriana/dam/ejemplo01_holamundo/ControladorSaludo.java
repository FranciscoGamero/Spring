package com.salesianostriana.dam.ejemplo01_holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Esa notacion indica que todos los métodos de la clase son controladores
			//( a parte de convertir la clase en un bean)
public class ControladorSaludo {
	
	@GetMapping({ "/", "welcome" })//De normal solo hay 1
	public String welcome(@RequestParam(name = "nombre", required = false,defaultValue = "Mundo") 
		String nombre,Model model) {
		model.addAttribute("nombre", nombre);/*Incluimos la información en el modelo, que esté entre 
										comillas indica el nombre de la variable que vamos a usar en el HTML*/
		
		return "index"; //Devuelve el nombre del HTML al que va, en este caso index.html
		}
}

