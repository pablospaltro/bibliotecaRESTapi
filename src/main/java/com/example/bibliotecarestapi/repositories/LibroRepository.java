package com.example.bibliotecarestapi.repositories;

import com.example.bibliotecarestapi.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

}
