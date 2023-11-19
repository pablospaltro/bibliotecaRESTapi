package com.example.bibliotecarestapi.repositories;

import com.example.bibliotecarestapi.entities.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Integer> {

    public abstract Lector findByNombre(String nombre);
}
