package com.example.bibliotecarestapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bibliotecarios_biblioteca")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Bibliotecario extends Usuario {

    private String turno;
}
