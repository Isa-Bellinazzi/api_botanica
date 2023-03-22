package br.com.magna.botanica.api.models;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.model.Classe;
import br.com.magna.botanica.api.model.Ordem;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
 class ConstructorOrdemTest {

    @Test
     void testOrdemConstructorWithId() {
        Long id = 1L;
        Ordem ordem = new Ordem(id);
        assertEquals(id, ordem.getId());
    }

    @Test
     void testOrdemConstructorWithDescricaoClasseAtivo() {
        String descricao = "Ordem Test";
        Classe classe = new Classe(1L);
        Boolean ativo = true;
        Ordem ordem = new Ordem(descricao, classe, ativo);
        assertEquals(descricao, ordem.getDescricao());
        assertEquals(classe, ordem.getClasseId());
        assertEquals(ativo, ordem.getAtivo());
    }
}


