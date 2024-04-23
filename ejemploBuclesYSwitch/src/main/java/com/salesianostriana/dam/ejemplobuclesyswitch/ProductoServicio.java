package com.salesianostriana.dam.ejemplobuclesyswitch;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ProductoServicio {

	public List<Producto> ObtenerLista(){
		return Arrays.asList(
				new Producto(1,"Botijo", "Enfría hasta menos 10 grados", 20.5055,true, LocalDateTime.now()),
				new Producto(2,"BotijoExtra","Enfría hasta menos 200 grados", 200.50, true, LocalDateTime.now())
				);
	}
}
