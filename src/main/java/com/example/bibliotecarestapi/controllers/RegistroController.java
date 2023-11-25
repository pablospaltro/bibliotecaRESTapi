package com.example.bibliotecarestapi.controllers;

import com.example.bibliotecarestapi.entities.Bibliotecario;
import com.example.bibliotecarestapi.entities.Lector;
import com.example.bibliotecarestapi.modelResponses.BibliotecarioModelResponse;
import com.example.bibliotecarestapi.modelResponses.LectorListaModelResponse;
import com.example.bibliotecarestapi.modelResponses.LectorModelResponse;
import com.example.bibliotecarestapi.response.ResponseHandlerObject;
import com.example.bibliotecarestapi.services.BibliotecarioService;
import com.example.bibliotecarestapi.services.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    BibliotecarioService bibliotecarioService;

    @Autowired
    LectorService lectorService;

    @GetMapping("/bibliotecario/vertodos")
    public List<Bibliotecario> VerTodosBibliotecario() {
        return bibliotecarioService.verBibliotecariosTodos();
    }

    @GetMapping("/bibliotecario/ver/{id}")
    public ResponseEntity<Object> verBibliotecarioPorId(@PathVariable("id") int id) {
        return ResponseHandlerObject.responseBuilder("Aqui estan los datos del bibliotecario solicitado.", HttpStatus.OK, bibliotecarioService.verBibliotecarioPorID(id));
    }


    @PostMapping("/bibliotecario/guardar")
    public ResponseEntity<BibliotecarioModelResponse> guardarNuevoBibliotecario(@RequestBody Bibliotecario bibliotecario){
        try{
            Bibliotecario bibliotecarioGuardado = bibliotecarioService.guardarBibliotecario(bibliotecario);
            return ResponseEntity.status(HttpStatus.CREATED).body(new BibliotecarioModelResponse("Operación exitosa, bibliotecario guardado.", "Status: CREATED", bibliotecarioGuardado));
        } catch (Exception e){
            bibliotecario = null;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BibliotecarioModelResponse("Datos incorrectos.", "Status: BAD_REQUEST", bibliotecario));
        }
    }


    @PutMapping("/bibliotecario/actualizar/id/{id}")
    public ResponseEntity<BibliotecarioModelResponse> actualizarBibliotecario(@PathVariable("id") Integer id, @RequestBody Bibliotecario bibliotecarioActualizado){
        try{
            bibliotecarioService.actualizarBibliotecario(bibliotecarioActualizado, id);
            return ResponseEntity.status(HttpStatus.OK).body(new BibliotecarioModelResponse("Operación exitosa, bibliotecario actualizado.", "Status: OK", bibliotecarioActualizado));
        } catch (Exception e){
            bibliotecarioActualizado = null;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BibliotecarioModelResponse("No se encontró el bibliotecario.", "Status: NOT_FOUND", bibliotecarioActualizado));
        }
    }


    @DeleteMapping("/bibliotecario/eliminar/id/{id}")
    public ResponseEntity<BibliotecarioModelResponse> eliminarBibliotecario(@PathVariable("id") Integer id){
        Bibliotecario bibliotecario = bibliotecarioService.verBibliotecarioPorID(id).get();
        try{
            bibliotecarioService.eliminarBiliotecario(id);
            return ResponseEntity.status(HttpStatus.OK).body(new BibliotecarioModelResponse("Operación exitosa, bibliotecario eliminado.", "Status: OK", bibliotecario));
        } catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BibliotecarioModelResponse("No se encontró el bibliotecario.", "Status: NOT_FOUND", bibliotecario));
        }
    }

    @GetMapping("/lector/vertodos")
    public ResponseEntity<LectorListaModelResponse> VerTodosLectores() {
        try{
            List<Lector> list = lectorService.verLectoresTodos();
            return ResponseEntity.status(HttpStatus.OK).body(new LectorListaModelResponse("Operación exitosa, mostrando lectores.", "Status: OK", list));
        } catch (Exception e){
            List<Lector> list = null;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new LectorListaModelResponse("No se encontraron lectores", "Status: NOT_FOUND", list));
        }
    }

    @GetMapping("/lector/ver/{id}")
    public ResponseEntity<Object> verLectorPorId(@PathVariable("id") int id) {
        return ResponseHandlerObject.responseBuilder("Aqui estan los datos del bibliotecario solicitado.", HttpStatus.OK, lectorService.verLectorPorID(id));
    }


    @PostMapping("/lector/guardar")
    public ResponseEntity<LectorModelResponse> guardarNuevoLector(@RequestBody Lector lector){
        try{
            Lector lectorGuardado = lectorService.guardarLector(lector);
            return ResponseEntity.status(HttpStatus.CREATED).body(new LectorModelResponse("Operación exitosa, lector guardado.", "Status: CREATED", lectorGuardado));
        } catch (Exception e){
            lector = null;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new LectorModelResponse("Datos incorrectos.", "Status: BAD_REQUEST", lector));
        }
    }


    @PutMapping("/lector/actualizar/id/{id}")
    public ResponseEntity<LectorModelResponse> actualizarLector(@PathVariable("id") Integer id, @RequestBody Lector lectorActualizado){
        try{
            lectorService.actualizarLector(lectorActualizado, id);
            return ResponseEntity.status(HttpStatus.OK).body(new LectorModelResponse("Operación exitosa, lector actualizado.", "Status: OK", lectorActualizado));
        } catch (Exception e){
            lectorActualizado = null;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new LectorModelResponse("No se encontró el lector.", "Status: NOT_FOUND", lectorActualizado));
        }
    }


    @DeleteMapping("/lector/eliminar/id/{id}")
    public ResponseEntity<LectorModelResponse> eliminarLector(@PathVariable("id") Integer id){
        Lector lector = lectorService.verLectorPorID(id).get();
        try{
            lectorService.eliminarLector(id);
            return ResponseEntity.status(HttpStatus.OK).body(new LectorModelResponse("Operación exitosa, lector eliminado.", "Status: OK", lector));
        } catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new LectorModelResponse("No se encontró el lector.", "Status: NOT_FOUND", lector));
        }
    }
}
