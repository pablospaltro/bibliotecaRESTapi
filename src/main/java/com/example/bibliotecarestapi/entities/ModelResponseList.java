package com.example.bibliotecarestapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter

public class ModelResponseList {

    String mensaje;
    List<Libro> libros;
}
