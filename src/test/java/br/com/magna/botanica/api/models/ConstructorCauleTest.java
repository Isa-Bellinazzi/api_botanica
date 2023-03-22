package br.com.magna.botanica.api.models;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.model.Caule;
import br.com.magna.botanica.api.model.Classe;
import br.com.magna.botanica.api.model.Filo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
 class ConstructorCauleTest {

    @Test
     void testCauleConstructorWithId() {
        Long id = 1L;
        Caule caule = new Caule(id);
        assertEquals(id, caule.getId());
    }

    @Test
     void testCauleConstructorWithDescricaoClasseIdAtivo() {
        String descricao = "Caule Test";
        Classe classe = new Classe(1L, "Classe Test", new Filo(1L), true);
        Boolean ativo = true;
        Caule caule = new Caule(descricao, classe, ativo);
        assertEquals(descricao, caule.getDescricao());
        assertEquals(classe, caule.getClasseId());
        assertEquals(ativo, caule.getAtivo());
    }
}





