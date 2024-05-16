package com.salesianostriana.dam.ejemplocarrito.servicio;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.ejemplocarrito.modelo.Producto;
import com.salesianostriana.dam.ejemplocarrito.repositorio.ProductoRepository;
import com.salesianostriana.dam.ejemplocarrito.servicio.base.BaseServiceImpl;


@Service
public class ProductoService extends BaseServiceImpl<Producto, Long, ProductoRepository> {

}
