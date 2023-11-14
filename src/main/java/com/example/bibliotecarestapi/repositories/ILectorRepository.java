package com.example.bibliotecarestapi.repositories;

import com.example.bibliotecarestapi.entities.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILectorRepository extends JpaRepository<Lector, Integer> {
}
