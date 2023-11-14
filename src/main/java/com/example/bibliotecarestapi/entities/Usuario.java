package com.example.bibliotecarestapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Usuario {

    @Id
    private Integer id;

    private String nombreCompleto;
    private String email;
    private String DNI;
    private String nickname;
    private String password;

}
