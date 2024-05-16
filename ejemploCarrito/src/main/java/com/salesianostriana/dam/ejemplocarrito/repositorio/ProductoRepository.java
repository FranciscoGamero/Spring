package com.salesianostriana.dam.ejemplocarrito.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.ejemplocarrito.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
