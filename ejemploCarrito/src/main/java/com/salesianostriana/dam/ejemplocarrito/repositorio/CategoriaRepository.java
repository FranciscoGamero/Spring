package com.salesianostriana.dam.ejemplocarrito.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.ejemplocarrito.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
