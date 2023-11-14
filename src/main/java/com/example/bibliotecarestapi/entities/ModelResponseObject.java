package com.example.bibliotecarestapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ModelResponseObject {

    private String mensaje;
    private Libro libro;
}
