package com.salesianostriana.dam.ejemploformulario2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.ejemploformulario2.model.Producto;
import com.salesianostriana.dam.ejemploformulario2.service.ProductoServicio;

@Controller
public class ProductoControlador {

	@Autowired
	private ProductoServicio service;
	
		@GetMapping("/producto")
		public String showFormProducto(Model model) {

			/*
			 * Agregamos al modelo un producto vacío, para que en la vista
			 * se puedan usar lso campos de un producto, vacíos, sin datos
			 * ya que es de agregar, no de modificar
			 * */
			Producto producto = new Producto();
			model.addAttribute("productoForm", producto);
			/*
			 * Traemos la lista de tipos de cerveza, simulando de nuevo con 
			 * el servicio que viene de la base de datos
			 * */
			model.addAttribute("tipos", service.getTipos());

			return "formProducto";
		}
		
		/*
		 * Como hemos visto, los formularios son atendidos por peticiones post, 
		 * este es el segundo método, el anotado con @PostMapping, para 
		 * recoger los datos de los campos del formulario y mandarlos a la base de 
		 * datos o donde sea necesario, en nuestro caso solo se pinta en otra página
		 * */
		@PostMapping("/addProducto")
		public String submit(@ModelAttribute("productoForm") Producto producto, Model model) {
			
				model.addAttribute("producto", producto);
				return "view";			
		}
	
}
