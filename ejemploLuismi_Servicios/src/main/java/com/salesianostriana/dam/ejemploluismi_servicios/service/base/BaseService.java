package com.salesianostriana.dam.ejemploluismi_servicios.service.base;

import java.util.List;
import java.util.Optional;
							//T es el tipo de dato que se guarda, y el ID es lo que lo define
							// T = Alumno, ID = dni, codigo de alumno...
public interface BaseService <T, ID>{
	
	List<T> findAll();
	
	Optional<T> findById(ID id);
	
	T save(T t);
	
	T edit(T t);
	
	void delete(T t);
	
	void deleteById(ID id);
}
