package com.example.bibliotecarestapi.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

@Embeddable
public class Autor {

    private String nombre;
    private String anioNacimiento;
    private String nacionalidad;

}
