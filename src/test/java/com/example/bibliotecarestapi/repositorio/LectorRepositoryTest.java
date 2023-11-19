package com.example.bibliotecarestapi.repositorio;

import com.example.bibliotecarestapi.entities.Lector;
import com.example.bibliotecarestapi.repositories.LectorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class LectorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    LectorRepository lectorRepository;

    Lector lector;

}
