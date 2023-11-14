package com.example.bibliotecarestapi.modelResponses;

import com.example.bibliotecarestapi.entities.Libro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LibrosListaModelResponse {

    private String mensaje;
    private String httpStatus;
    private List<Libro> libros;
}
