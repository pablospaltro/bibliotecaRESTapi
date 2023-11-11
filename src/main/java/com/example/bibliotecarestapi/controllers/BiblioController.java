package com.example.bibliotecarestapi.controllers;

import com.example.bibliotecarestapi.entities.Libro;
import com.example.bibliotecarestapi.entities.ModelResponseList;
import com.example.bibliotecarestapi.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class BiblioController {

    @Autowired
    LibroService libroService;

    @GetMapping("/libro/vertodos")
    public ResponseEntity<ModelResponseList> biblioVerTodosLibros() {
        try{
            List<Libro> list = libroService.verLibrosTodos();
            return ResponseEntity.status(HttpStatus.OK).body(new ModelResponseList("Operación exitosa.", list));
        } catch (Exception e){
            List<Libro> list = null;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ModelResponseList("No se encontraron libros", list));
        }
    }

    @GetMapping("/libro/ver/{id}")
    public ResponseEntity<Libro> biblioLibroVerPorId(@PathVariable("id") int id) {
        try{
            Libro libro = libroService.verLibrosPorID(id).get();
            return ResponseEntity.status(HttpStatus.OK).body(libro);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
