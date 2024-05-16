package com.salesianostriana.dam.ejemplocarrito.servicio;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.ejemplocarrito.modelo.Categoria;
import com.salesianostriana.dam.ejemplocarrito.repositorio.CategoriaRepository;
import com.salesianostriana.dam.ejemplocarrito.servicio.base.BaseServiceImpl;

@Service
public class CategoriaService extends BaseServiceImpl<Categoria, Long, CategoriaRepository> {

}
