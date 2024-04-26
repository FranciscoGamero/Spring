package com.salesianostriana.dam.ejemploformulario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.ejemploformulario.model.Empleado;

@Controller
public class EmpleadoController {

	@GetMapping("/")
	public String mostrarFormulario(Model model) {
		Empleado empleado = new Empleado();
		model.addAttribute("empleadoForm",empleado);
		return "form";	
	}
	@PostMapping("/addEmpleado")
	public String enviar(@ModelAttribute("empleadoForm") Empleado empleado, Model model) {
		model.addAttribute("empleado", empleado);
		return "view";
	}
}
