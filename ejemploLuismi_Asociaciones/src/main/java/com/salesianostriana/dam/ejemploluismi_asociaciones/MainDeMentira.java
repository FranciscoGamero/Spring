package com.salesianostriana.dam.ejemploluismi_asociaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.ejemploluismi_asociaciones.modelo.Alumno;
import com.salesianostriana.dam.ejemploluismi_asociaciones.modelo.Curso;
import com.salesianostriana.dam.ejemploluismi_asociaciones.respositorios.AlumnoRepository;
import com.salesianostriana.dam.ejemploluismi_asociaciones.respositorios.CursoRepository;

import jakarta.annotation.PostConstruct;

@Component
public class MainDeMentira {

	//Las clases que no son entidades no se pueden inyectar
    @Autowired
    private AlumnoRepository repo;
    
    @Autowired
    private CursoRepository cursoRepo;
    
    @PostConstruct
    void ejercutar() {
        /*repo.save(new Alumno("Candi", "Alcantarilla", "candicalado@gmail.com"));
        repo.save(new Alumno("Fran", "Gamero", "frangamero@gmail.com"));
        repo.findAll().forEach(System.out::println);;*/
        
        Curso c  = new Curso("1º DAM");
        cursoRepo.save(c);
        
        Alumno a = new Alumno("Candi", "Alcantarilla", "candicalado@gmail.com");
        repo.save(a);
        
        a.addtoCurso(c);
        
        repo.findAll().forEach(System.out::println);

	}
}
