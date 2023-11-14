package com.example.bibliotecarestapi.modelResponses;

import com.example.bibliotecarestapi.entities.Libro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LibroModelResponse {

    private String mensaje;
    private String httpStatus;
    private Libro libro;
}
