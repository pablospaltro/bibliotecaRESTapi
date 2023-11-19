package com.example.bibliotecarestapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "lectores_biblioteca")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Lector extends Usuario{

    @OneToMany
    private List<Libro> librosPrestados;
}
