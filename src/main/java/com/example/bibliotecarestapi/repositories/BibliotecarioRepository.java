package com.example.bibliotecarestapi.repositories;

import com.example.bibliotecarestapi.entities.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Integer> {
}
