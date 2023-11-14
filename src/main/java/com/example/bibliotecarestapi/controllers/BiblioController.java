package com.example.bibliotecarestapi.controllers;

import com.example.bibliotecarestapi.entities.Libro;
import com.example.bibliotecarestapi.entities.ModelResponseList;
import com.example.bibliotecarestapi.entities.ModelResponseObject;
import com.example.bibliotecarestapi.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class BiblioController {

    @Autowired
    LibroService libroService;

    @GetMapping("/libro/vertodos")
    public ResponseEntity<ModelResponseList> VerTodosLibros() {
        try{
            List<Libro> list = libroService.verLibrosTodos();
            return ResponseEntity.status(HttpStatus.OK).body(new ModelResponseList("Operación exitosa, mostrando libros", list));
        } catch (Exception e){
            List<Libro> list = null;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ModelResponseList("No se encontraron libros", list));
        }
    }

    @GetMapping("/libro/ver/{id}")
    public ResponseEntity<ModelResponseObject> verLibroPorId(@PathVariable("id") int id) {
        try{
            Libro libro = libroService.verLibrosPorID(id).get();
            return ResponseEntity.status(HttpStatus.OK).body(new ModelResponseObject("Operación exitosa, mostrando libro.", libro));
        } catch (Exception e){
            Libro libro = null;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ModelResponseObject("No se encontró el libro.", libro));
        }
    }


    @PostMapping("/libro/guardar")
    public ResponseEntity<ModelResponseObject> guardarNuevoLibro(@RequestBody Libro libro){
        try{
            libroService.guardarLibro(libro);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ModelResponseObject("Operación exitosa, libro guardado.", libro));
        } catch (Exception e){
            libro = null;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ModelResponseObject("Datos incorrectos.", libro));
        }
    }

    @PutMapping("/libro/actualizar/id/{id}")
    public ResponseEntity<ModelResponseObject> actualizarLibro(@PathVariable("id") Integer id, @RequestBody Libro libroActualizado){
        try{
            libroService.actualizarLibro(libroActualizado, id);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ModelResponseObject("Operación exitosa, libro actualizado.", libroActualizado));
        } catch (Exception e){
            libroActualizado = null;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ModelResponseObject("No se encontró el libro.", libroActualizado));
        }
    }

    @DeleteMapping("/libro/eliminar/id/{id}")
    public ResponseEntity<ModelResponseObject> eliminarLibro(@PathVariable("id") Integer id){
        Libro libro = libroService.verLibrosPorID(id).get();
        try{
            libroService.eliminarLibro(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ModelResponseObject("Operación exitosa, libro eliminado.", libro));
        } catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ModelResponseObject("No se encontró el libro.", libro));
        }
    }
}
