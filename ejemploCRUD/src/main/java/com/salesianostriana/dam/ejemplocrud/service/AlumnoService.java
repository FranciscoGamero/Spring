package com.salesianostriana.dam.ejemplocrud.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.ejemplocrud.model.Alumno;
import com.salesianostriana.dam.ejemplocrud.repository.AlumnoRepository;
import com.salesianostriana.dam.ejemplocrud.service.base.BaseServiceImpl;

@Service
public class AlumnoService extends BaseServiceImpl<Alumno, Long, AlumnoRepository>{

}
