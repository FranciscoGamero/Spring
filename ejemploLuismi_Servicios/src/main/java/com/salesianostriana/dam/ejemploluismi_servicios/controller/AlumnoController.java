package com.salesianostriana.dam.ejemploluismi_servicios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.ejemploluismi_servicios.service.AlumnoService;

@Controller
public class AlumnoController {
	
	@Autowired
	private AlumnoService servicioAlumno;
	
	@GetMapping({"/","/list"})
	public String lista(Model model) {
		model.addAttribute("alumnos", servicioAlumno.findAll());
		return "lista";
	}

}