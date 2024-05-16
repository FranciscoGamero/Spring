package com.salesianostriana.dam.ejemplocarrito.servicio;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.ejemplocarrito.modelo.Usuario;
import com.salesianostriana.dam.ejemplocarrito.modelo.Venta;
import com.salesianostriana.dam.ejemplocarrito.repositorio.VentaRepository;
import com.salesianostriana.dam.ejemplocarrito.servicio.base.BaseServiceImpl;

@Service
public class VentaService extends BaseServiceImpl<Venta, Long, VentaRepository>{
	
	public boolean existeVentaNoFinalizada(Usuario cliente) {
		return this.repository.existByFinalizadaAndUsuario(cliente);
	}
	public Optional<Venta> getVentaNoFinalizada(Usuario cliente){
		return this.repository.existVentaNoFinalizada(cliente);
	}
	
}
