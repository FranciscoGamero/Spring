package com.salesianostriana.dam.ejemplocarrito.servicio;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.ejemplocarrito.modelo.LineaVenta;
import com.salesianostriana.dam.ejemplocarrito.modelo.Producto;
import com.salesianostriana.dam.ejemplocarrito.modelo.Usuario;
import com.salesianostriana.dam.ejemplocarrito.modelo.Venta;

@Service
public class CarritoService {

	@Autowired
	VentaService ventaServicio;

	public Venta getCarrito(Usuario usuario) {
		return ventaServicio.getVentaNoFinalizada(usuario).orElseGet(() -> crearCarrito(usuario));
	}

	public void addProducto(Usuario usuario, Producto producto, int cantidad) {
		Venta carrito = getCarrito(usuario);

		if (!ventaServicio.hayProductoEnCarrito(usuario, producto)) {
			carrito.addLineaVenta(LineaVenta.builder());
		} else {
			Optional<LineaVenta> lv = buscarPorProducto(usuario, carrito);
			if (lv.isPresent()) {
				modificarCantidad(usuario, producto, lv.get().getCantidad() + 1);
			}
		}
		ventaServicio.edit(carrito);
	}

	public void eliminarProducto(Usuario usuario, Producto producto) {
		Venta carrito = getCarrito(usuario);
		Optional<LineaVenta> aEliminar = buscarPorProducto(usuario, producto);
		if (aEliminar.isPresent()) {
			ventaServicio.save(carrito);
		}
	}

	public Optional<LineaVenta> buscarPorProducto(Usuario usuario, Producto producto) {
		Venta carrito = getCarrito(usuario);

		return carrito.getLineasVenta().stream().filter(lv -> lv.getProducto().getId() == producto.getId()).findFirst();
	}

	public void modificarCantidad(Usuario usuario, Producto producto, int cantidad) {
		Venta carrito = getCarrito(usuario);

		if (cantidad <= 0) {
			eliminarProducto(usuario, producto);
		} else {
			Optional<LineaVenta> aMod = buscarPorProducto(usuario, producto);
			if (aMod.isPresent()) {
				LineaVenta lv = aMod.get();
				lv.setCantidad(cantidad);
				ventaServicio.edit(carrito);
			} else {
				addProducto(usuario, producto, cantidad);
			}
		}
	}

	public void finalizarCompra(Usuario us) {
		Venta carrito = getCarrito(us);
		carrito.setFinalizada(true);
		carrito.setFechaPedido(LocalDateTime.now());
		carrito.setImporteTotal(getImporteTotal(us));
		ventaServicio.edit(carrito);
	}
	
	public boolean hayCarritoCreado(Usuario u) {
		return ventaServicio.existeVentaNoFinalizada(u);
	}
	public Venta crearCarrito(Usuario usuario) {}
	
	public Map<Producto,Integer> getProductosEnCarrito(Usuario us){
		return getCarrito(us)
				.getLineasVenta()
				.stream()
				.collect(Collectors.toMap(lv -> lv.getProducto(), lv -> lv.getCantidad()));
	}
	public double getImporteTotal(Usuario usuario) {
		return getCarrito(usuario).getLineasVenta()
				.stream()
				.mapToDouble(LineaVenta::getPrecioLineaVenta)
				.sum();
	}
}
