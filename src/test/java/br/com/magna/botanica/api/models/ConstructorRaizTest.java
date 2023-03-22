package br.com.magna.botanica.api.models;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.model.Classe;
import br.com.magna.botanica.api.model.Filo;
import br.com.magna.botanica.api.model.Raiz;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
 class ConstructorRaizTest {

	    @Test
	    void testRaizConstructorWithId() {
	        Long id = 1L;
	        Raiz raiz = new Raiz(id);
	        assertEquals(id, raiz.getId());
	    }

	    @Test
	    void testRaizConstructorWithDescricaoClasseIdAtivo() {
	        String descricao = "Raiz Test";
	        Classe classe = new Classe(1L, "Classe Test", new Filo(1L), true);
	        Boolean ativo = true;
	        Raiz raiz = new Raiz(descricao, classe, ativo);
	        assertEquals(descricao, raiz.getDescricao());
	        assertEquals(classe, raiz.getClasseId());
	        assertEquals(ativo, raiz.getAtivo());
	    }
	}