package com.salesianostriana.dam.ejemploluismi_asociaciones.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Curso {
	    @Id @GeneratedValue
	    private Long id;
	    
	    private String nombre;
	    /*
	    @OneToMany Solución una a muchos, donde se pone una lista del uno (alumno) en el muchos (curso)
	    private List<Alumno> alumnos = new ArrayList<>();
	    No es una buena solucion, ya que genera una tercera tabla 
	    */
	    
	    //Lo que se pone dentro es el nombre de la clase de enfrente que tiene el atributo anotada con ManyToOne
	    @OneToMany(mappedBy="curso", fetch = FetchType.EAGER)
	    @EqualsAndHashCode.Exclude
	    @ToString.Exclude
	    private List<Alumno> alumnos = new ArrayList<>();
	    
	    public Curso(String nombre) {
	        super();
	        this.nombre = nombre;
	    }
}