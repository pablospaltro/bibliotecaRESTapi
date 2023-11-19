package com.example.bibliotecarestapi.services;

import com.example.bibliotecarestapi.entities.Lector;
import com.example.bibliotecarestapi.repositories.LectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LectorService {

    @Autowired
    LectorRepository lectorRepository;

    public List<Lector> verLectoresTodos() {
        return lectorRepository.findAll();
    }

    public Optional<Lector> verLectorPorID(int id) {
        return lectorRepository.findById(id);
    }

    public Lector guardarLector(Lector nuevoLector) {
        return lectorRepository.save(nuevoLector);
    }

    public Lector actualizarLector(Lector lectorActualizado, Integer id){

        Lector lectorAActualizar = lectorRepository.findById(id).get();

        lectorAActualizar.setNombreCompleto(lectorActualizado.getNombreCompleto());
        lectorAActualizar.setEmail(lectorActualizado.getEmail());
        lectorAActualizar.setDni(lectorActualizado.getDni());
        lectorAActualizar.setNickname(lectorActualizado.getNickname());
        lectorAActualizar.setPassword(lectorActualizado.getPassword());
        lectorAActualizar.setLibrosPrestados(lectorActualizado.getLibrosPrestados());

        return lectorRepository.save(lectorActualizado);
    }

    public void eliminarLector(int id) {
        lectorRepository.deleteById(id);
    }
}
