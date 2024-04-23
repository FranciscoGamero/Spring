package com.salesianostriana.dam.ejemploluismi_conectarbddhibernate.respositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.ejemploluismi_conectarbddhibernate.modelo.Alumno;

//Con esto ya podemos instertar, consultar, modificar alumnos
//No hace falta poner el @Repository aunque se puede hacer, no cambia nada
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}
