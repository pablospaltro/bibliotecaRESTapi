package com.example.bibliotecarestapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "libros_biblioteca")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Libro {

    @Id
    private Integer id;

    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    private String editorial;

    private int anioPublicacion;

    private String isbn;

    private boolean estaDisponible;


}
