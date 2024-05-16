package com.salesianostriana.dam.ejemplocarrito.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.ejemplocarrito.modelo.Usuario;
import com.salesianostriana.dam.ejemplocarrito.modelo.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long>{

	public boolean existByFinalizadaAndUsuario(Usuario usuario);
	
}
