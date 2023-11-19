package com.example.bibliotecarestapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios_biblioteca")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreCompleto;
    private String email;
    private String dni;
    private String nickname;
    private String password;

}
