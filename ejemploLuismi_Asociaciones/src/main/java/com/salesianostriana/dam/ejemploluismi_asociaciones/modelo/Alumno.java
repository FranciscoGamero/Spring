package com.salesianostriana.dam.ejemploluismi_asociaciones.modelo;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Data
@Table(name ="alumnado")
public class Alumno {

    @Id @GeneratedValue //Esto hace que se genere solo en la BDD
    private long id;
    
    @Column(columnDefinition = "VARCHAR(100)")
    private String nombre;
    
    @Column(columnDefinition = "VARCHAR (340)")
    private String apellidos;
    private String email;
    
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="fk_alumno_curso"))
    private Curso curso;

    public Alumno(String nombre, String apellidos, String email, Curso curso) {
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.curso = curso;
    }
    
    public Alumno(String nombre, String apellidos, String email) {
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }
    //Añadirlo en el lado que no esta mapeado
    
    //Metodo auxiliares 
    
    public void addtoCurso(Curso c) {
        this.curso = c;
        c.getAlumnos().add(this);
    }
    
    public void removeFromCurso(Curso c) {
        c.getAlumnos().remove(this);
        this.curso=null;
    }	
}
