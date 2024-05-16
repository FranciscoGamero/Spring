package com.salesianostriana.dam.ejemplocarrito.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.ejemplocarrito.modelo.Producto;
import com.salesianostriana.dam.ejemplocarrito.repositorio.ProductoRepository;
import com.salesianostriana.dam.ejemplocarrito.servicio.base.BaseServiceImpl;


@Service
public class ProductoService extends BaseServiceImpl<Producto, Long, ProductoRepository> {

	public List<Producto> buscar(String cadena){
		List<Producto> lista = this.repository.findByNombreContainsIgnoreCaseOrDescripcionContains(cadena);
	/*	
		if(lista.isEmpty()) {
			throw new ProductoNotFoundException
		}
		*/
	}
}
