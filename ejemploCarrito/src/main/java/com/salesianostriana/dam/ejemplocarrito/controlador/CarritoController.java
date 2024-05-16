package com.salesianostriana.dam.ejemplocarrito.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.ejemplocarrito.modelo.Producto;
import com.salesianostriana.dam.ejemplocarrito.modelo.Usuario;
import com.salesianostriana.dam.ejemplocarrito.servicio.CarritoService;
import com.salesianostriana.dam.ejemplocarrito.servicio.ProductoService;


@Controller
public class CarritoController {

	@Autowired
	private CarritoService servicioCarrito;
	
	@Autowired
	private ProductoService servicioProducto;
	
	@GetMapping("/carrito")
	public String showCarrito(@AuthenticationPrincipal Usuario usuario, Model model) {
		if(servicioCarrito.hayCarritoCreado(usuario)) {
			model.addAttribute("productos",servicioCarrito.getProductosEnCarrito(usuario));
			return "carrito";
		} else {
			return "redirect:/";
		}
	}
	@GetMapping("/productoACarrito/{id}")
	public String productoACarrito(@AuthenticationPrincipal Usuario usuario, @PathVariable ("id") Long id,Model model) {
		Optional<Producto> producto = servicioProducto.findById(id);
		if(producto.isPresent()) {
			servicioCarrito.addProducto(usuario, producto.get(), 1);
			return "redirect:/carrito";
		}
		return "redirect:/list";
	}
	
	@PostMapping("/checkout")
	public String finalizarCompra(@AuthenticationPrincipal Usuario usuario) {
		servicioCarrito.finalizarCompra(usuario);
		return "redirect:/list";
	}
	//GetMapping("/carrito/eliminar/{id}")
	@GetMapping("/carrito/modificar/{id}/cantidad/{cant}")
	public String modificarCantProducto(@AuthenticationPrincipal Usuario usuario,@PathVariable ("id") Long id,@PathVariable ("cant") int cant) {
		Optional<Producto> producto = servicioProducto.findById(id);
		if(producto.isPresent()) {
			servicioCarrito.modificarCantidad(usuario, producto.get(), cant);
		}
		return "redirect:/carrito";
	}
}
