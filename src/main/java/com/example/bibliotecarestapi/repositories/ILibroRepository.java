package com.example.bibliotecarestapi.repositories;

import com.example.bibliotecarestapi.entities.Autor;
import com.example.bibliotecarestapi.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Integer> {

}
