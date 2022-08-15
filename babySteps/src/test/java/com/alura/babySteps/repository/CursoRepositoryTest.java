package com.alura.babySteps.repository;

import com.alura.babySteps.modelo.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//COM ESSA ANOTAÇÃO IREI TESTAR MINHA BASE DE DADOS E NAO BD INMEMORY
@ActiveProfiles("test")
class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void deveriaCursofindByNome() {
        String nomeCurso = "HTML 5";

        Curso html5 = new Curso();
        html5.setNome(nomeCurso);
        html5.setCategoria("Programacao");
        entityManager.persist(html5);


        Curso curso = repository.findByNome(nomeCurso);
        Assertions.assertNotNull(curso);
        Assertions.assertEquals(nomeCurso, curso.getNome());


    }

    @Test
    public void naodeveriaCursofindByNome() {
        String nomeCurso = "JPA";
        Curso curso = repository.findByNome(nomeCurso);

        Assertions.assertNull(curso);
    }
}