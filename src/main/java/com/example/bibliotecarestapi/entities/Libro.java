package com.example.bibliotecarestapi.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Libro {

    @Id
    private Integer id;

    private String titulo;

    @Embedded
    private Autor autor;

    private String editorial;

    private int anioPublicacion;

    private String ISBN;
}
