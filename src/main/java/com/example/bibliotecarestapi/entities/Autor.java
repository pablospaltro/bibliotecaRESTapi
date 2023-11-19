package com.example.bibliotecarestapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "autores_biblioteca")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter


public class Autor {

    @Id
    private Integer id;
    private String nombre;
    private String anioNacimiento;
    private String nacionalidad;

    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

}
