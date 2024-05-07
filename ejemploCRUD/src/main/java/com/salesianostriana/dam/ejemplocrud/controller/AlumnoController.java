package com.salesianostriana.dam.ejemplocrud.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.ejemplocrud.model.Alumno;
import com.salesianostriana.dam.ejemplocrud.service.AlumnoService;

@Controller
public class AlumnoController {

	private AlumnoService servicioAlumno;
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		
		Optional<Alumno> aEditar = servicioAlumno.findById(id);
		
		if(aEditar.isPresent()) {
			model.addAttribute("alumno", aEditar.get());
			return "formulario";
		} else {
			return "redirect:/";
		}
	}
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("alumno") Alumno a) {
		servicioAlumno.edit(a);
		return "redirect:/";
	}
	@GetMapping("/editar/{id}")
	public String borrarAlumno(@PathVariable("id") long id, Model model) {
		
		Optional<Alumno> aBorrar = servicioAlumno.findById(id);
		
		if(aBorrar.isPresent()) {
			servicioAlumno.delete(aBorrar.get());
		}
		return "redirect:/";
		
	}
}
