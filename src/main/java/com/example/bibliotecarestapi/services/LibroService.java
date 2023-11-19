package com.example.bibliotecarestapi.services;

import com.example.bibliotecarestapi.entities.Autor;
import com.example.bibliotecarestapi.entities.Libro;
import com.example.bibliotecarestapi.repositories.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    ILibroRepository libroRepository;

    public List<Libro> verLibrosTodos() {
        return libroRepository.findAll();
    }

    public Optional<Libro> verLibrosPorID(int id) {
        return libroRepository.findById(id);
    }

    public Libro guardarLibro(Libro libroNuevo) {
        return libroRepository.save(libroNuevo);
    }

    public Libro actualizarLibro(Libro libroActualizado, Integer id){
        Libro libroAActualizar = libroRepository.findById(id).get();
        libroAActualizar.setTitulo(libroActualizado.getTitulo());
        libroAActualizar.setAutor(libroActualizado.getAutor());
        libroAActualizar.setEditorial(libroActualizado.getEditorial());
        libroAActualizar.setIsbn(libroActualizado.getIsbn());
        libroAActualizar.setAnioPublicacion(libroActualizado.getAnioPublicacion());
        libroAActualizar.setEstaDisponible(libroActualizado.isEstaDisponible());
        return libroRepository.save(libroActualizado);
    }

    public void eliminarLibro(int id) {
        libroRepository.deleteById(id);
    }

    public boolean existeLibroPorID(int id) {
        return libroRepository.existsById(id);
    }



}
