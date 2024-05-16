package com.salesianostriana.dam.ejemplocarrito.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.ejemplocarrito.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	
	//En el servicio se le pasan los nombres y descripción
	List<Producto> findByNombreContainsIgnoreCaseOrDescripcionContains(String nombre);
}
