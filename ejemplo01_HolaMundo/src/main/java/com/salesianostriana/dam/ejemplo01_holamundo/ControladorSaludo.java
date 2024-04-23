package com.salesianostriana.dam.ejemplo01_holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //Esa notacion indica que todos los métodos de la clase son controladores
			//( a parte de convertir la clase en un bean)
public class ControladorSaludo {
	
	@GetMapping({ "/", "welcome" })//De normal solo hay 1
	public String welcome(@RequestParam(name = "nombre", required = false,defaultValue = "Mundo") 
		String nombre,Model model){/*A la hora de importar casi siempre es mejor lo que este relacionado con Spring*/
		model.addAttribute("nombre", nombre);/*Incluimos la información en el modelo, que esté entre 
										comillas indica el nombre de la variable que vamos a usar en el HTML*/
		
		return "index"; //Devuelve el nombre del HTML al que va PERO SIN EL .HTML, en este caso index.html
		}
	
	@GetMapping("/saludo2")
	public String welcome2(Model model) {
		model.addAttribute("persona", new Persona("Ángel", "Naranjo González"));/* Se pone asi porque
																				no tenemos una BDD*/
		return "SaludoPersonalizado";
	}
	@GetMapping ("/saludo3")
	public String welcome3(Model model) {
	model.addAttribute("saludo", "Hola Mundo");
	model.addAttribute("mensaje", "¡Se me está haciendo largo el proyecto final!"); 
	model.addAttribute("url", "https://triana.salesianos.edu");
	return "SaludoPersonalizado2";
	}
}

