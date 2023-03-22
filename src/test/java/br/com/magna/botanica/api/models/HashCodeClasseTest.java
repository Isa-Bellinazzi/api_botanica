package br.com.magna.botanica.api.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.model.Caule;
import br.com.magna.botanica.api.model.Classe;
import br.com.magna.botanica.api.model.Filo;
import br.com.magna.botanica.api.model.Folhagem;
import br.com.magna.botanica.api.model.Ordem;
import br.com.magna.botanica.api.model.Planta;
import br.com.magna.botanica.api.model.Raiz;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class HashCodeClasseTest {


    @Test
     void testEqualsAndHashCode() {
        Filo filo = new Filo(1L, "Filo Teste", true, true, true, true, true, true, true);
        Classe classe1 = new Classe(1L, "Classe Teste 1", filo, true);
        Classe classe2 = new Classe(1L, "Classe Teste 2", filo, false);
        Classe classe3 = new Classe(2L, "Classe Teste 1", filo, true);

        assertEquals(classe1, classe2); // Verifica se os objetos com o mesmo id são iguais
        assertNotEquals(classe1, classe3); // Verifica se os objetos com ids diferentes são diferentes

        assertEquals(classe1.hashCode(), classe2.hashCode()); // Verifica se os objetos com o mesmo id têm o mesmo hashcode
        assertNotEquals(classe1.hashCode(), classe3.hashCode()); // Verifica se os objetos com ids diferentes têm hashcodes diferentes
    }
}
