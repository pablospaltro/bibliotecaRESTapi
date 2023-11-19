package com.example.bibliotecarestapi.services;

import com.example.bibliotecarestapi.entities.Bibliotecario;
import com.example.bibliotecarestapi.repositories.BibliotecarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BibliotecarioService {

    @Autowired
    BibliotecarioRepository bibliotecarioRepository;

    public List<Bibliotecario> verBibliotecariosTodos() {
        return bibliotecarioRepository.findAll();
    }

    public Optional<Bibliotecario> verBibliotecarioPorID(int id) {
        return bibliotecarioRepository.findById(id);
    }

    public Bibliotecario guardarBibliotecario(Bibliotecario nuevoBibliotecario) {
        return bibliotecarioRepository.save(nuevoBibliotecario);
    }

    public Bibliotecario actualizarBibliotecario(Bibliotecario bibliotecarioActualizado, Integer id){
        Bibliotecario bibliotecarioAActualizar = bibliotecarioRepository.findById(id).get();

        bibliotecarioAActualizar.setNombreCompleto(bibliotecarioActualizado.getNombreCompleto());
        bibliotecarioAActualizar.setEmail(bibliotecarioActualizado.getEmail());
        bibliotecarioAActualizar.setDni(bibliotecarioActualizado.getDni());
        bibliotecarioAActualizar.setNickname(bibliotecarioActualizado.getNickname());
        bibliotecarioAActualizar.setPassword(bibliotecarioActualizado.getPassword());
        bibliotecarioAActualizar.setTurno(bibliotecarioActualizado.getTurno());

        return bibliotecarioRepository.save(bibliotecarioAActualizar);
    }


    public void eliminarBiliotecario(int id) {
        bibliotecarioRepository.deleteById(id);
    }
}
