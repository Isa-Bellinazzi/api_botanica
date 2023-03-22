package br.com.magna.botanica.api.models;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.model.Classe;
import br.com.magna.botanica.api.model.Filo;
import br.com.magna.botanica.api.model.Folhagem;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
 class ConstructorFolhagemTest {

    @Test
     void testCauleConstructorComId() {
        Long id = 1L;
        Folhagem caule = new Folhagem(id);
        assertEquals(id, caule.getId());
    }

    @Test
     void testFolhagemConstructor() {
        String descricao = "Folhagem Teste";
        Classe classe = new Classe(1L, "Classe Test", new Filo(1L), true);
        Boolean ativo = true;
        Folhagem folhagem = new Folhagem(descricao, classe, ativo);
        assertEquals(descricao, folhagem.getDescricao());
        assertEquals(classe, folhagem.getClasseId());
        assertEquals(ativo, folhagem.getAtivo());
    }
}





