package com.example.bibliotecarestapi.modelResponses;

import com.example.bibliotecarestapi.entities.Lector;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LectorModelResponse {

    private String mensaje;
    private String httpStatus;
    private Lector lector;
}
