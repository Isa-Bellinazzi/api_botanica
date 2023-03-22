package br.com.magna.botanica.api.models;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.model.Classe;
import br.com.magna.botanica.api.model.Filo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
 class ConstructorClasseTest {


    @Test
     void testClasseConstructorWithId() {
        Long id = 1L;
        Classe classe = new Classe(id);
        assertEquals(id, classe.getId());
    }

    @Test
    void testClasseConstructorWithDescricaoIdFiloAtivo() {
        String descricao = "Classe Test";
        Filo filo = new Filo(1L);
        Boolean ativo = true;
        Classe classe = new Classe(descricao, filo, ativo);
        assertEquals(descricao, classe.getDescricao());
        assertEquals(filo, classe.getIdFilo());
        assertEquals(ativo, classe.getAtivo());
    }
}






