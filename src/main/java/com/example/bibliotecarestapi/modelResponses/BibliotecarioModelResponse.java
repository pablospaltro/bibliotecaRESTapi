package com.example.bibliotecarestapi.modelResponses;

import com.example.bibliotecarestapi.entities.Bibliotecario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BibliotecarioModelResponse {

    private String mensaje;
    private String httpStatus;
    private Bibliotecario bibliotecario;
}
