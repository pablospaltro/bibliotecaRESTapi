package com.example.bibliotecarestapi.repositorio;

import com.example.bibliotecarestapi.entities.Lector;
import com.example.bibliotecarestapi.repositories.LectorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class LectorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    LectorRepository lectorRepository;

    Lector lector1;
/*
    @BeforeEach
    public void setUp() {
        lector1 = new Lector();
        lector1.setNombreCompleto("Roberto");
        entityManager.persist(lector1);
    }

    @AfterEach
    void tearDown() {
        entityManager.clear();
    }

    @Test
    public void testFindByNombre_Found() {
        String nombre = "Roberto";

        Lector lector2 = lectorRepository.findByUsuarioNombre(nombre);
        assertThat(lector2).isNotNull();
        assertThat(lector2.getNombreCompleto()).isEqualTo(nombre);
    }
 */

}
