package com.example.bibliotecarestapi.repositories;

import com.example.bibliotecarestapi.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuariorepository extends JpaRepository<Usuario, Integer> {
}
