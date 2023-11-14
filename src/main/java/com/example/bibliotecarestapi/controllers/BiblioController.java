package com.example.bibliotecarestapi.controllers;

import com.example.bibliotecarestapi.entities.Libro;
import com.example.bibliotecarestapi.modelResponses.LibroModelResponse;
import com.example.bibliotecarestapi.modelResponses.LibrosListaModelResponse;
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
    public ResponseEntity<LibrosListaModelResponse> VerTodosLibros() {
        try{
            List<Libro> list = libroService.verLibrosTodos();
            return ResponseEntity.status(HttpStatus.OK).body(new LibrosListaModelResponse("Operación exitosa, mostrando libros", "Status: OK", list));
        } catch (Exception e){
            List<Libro> list = null;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new LibrosListaModelResponse("No se encontraron libros", "Status: NOT_FOUND", list));
        }
    }

    @GetMapping("/libro/ver/{id}")
    public ResponseEntity<LibroModelResponse> verLibroPorId(@PathVariable("id") int id) {
        try{
            Libro libro = libroService.verLibrosPorID(id).get();
            return ResponseEntity.status(HttpStatus.OK).body(new LibroModelResponse("Operación exitosa, mostrando libro.", "Status: OK", libro));
        } catch (Exception e){
            Libro libro = null;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new LibroModelResponse("No se encontró el libro.", "Status: NOT_FOUND", libro));
        }
    }


    @PostMapping("/libro/guardar")
    public ResponseEntity<LibroModelResponse> guardarNuevoLibro(@RequestBody Libro libro){
        try{
            libroService.guardarLibro(libro);
            return ResponseEntity.status(HttpStatus.CREATED).body(new LibroModelResponse("Operación exitosa, libro guardado.", "Status: CREATED", libro));
        } catch (Exception e){
            libro = null;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new LibroModelResponse("Datos incorrectos.", "Status: BAD_REQUEST", libro));
        }
    }

    @PutMapping("/libro/actualizar/id/{id}")
    public ResponseEntity<LibroModelResponse> actualizarLibro(@PathVariable("id") Integer id, @RequestBody Libro libroActualizado){
        try{
            libroService.actualizarLibro(libroActualizado, id);
            return ResponseEntity.status(HttpStatus.CREATED).body(new LibroModelResponse("Operación exitosa, libro actualizado.", "Status: CREATED", libroActualizado));
        } catch (Exception e){
            libroActualizado = null;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new LibroModelResponse("No se encontró el libro.", "Status: NOT_FOUND", libroActualizado));
        }
    }

    @DeleteMapping("/libro/eliminar/id/{id}")
    public ResponseEntity<LibroModelResponse> eliminarLibro(@PathVariable("id") Integer id){
        Libro libro = libroService.verLibrosPorID(id).get();
        try{
            libroService.eliminarLibro(id);
            return ResponseEntity.status(HttpStatus.OK).body(new LibroModelResponse("Operación exitosa, libro eliminado.", "Status: OK", libro));
        } catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new LibroModelResponse("No se encontró el libro.", "Status: NOT_FOUND", libro));
        }
    }
}
