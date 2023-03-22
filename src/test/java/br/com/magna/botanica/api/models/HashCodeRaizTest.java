package br.com.magna.botanica.api.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.model.Classe;
import br.com.magna.botanica.api.model.Raiz;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class HashCodeRaizTest {
    @Test
    void testEqualsAndHashCode() {
        Classe classe1 = new Classe(1L);
        Classe classe2 = new Classe(2L);

        Raiz raiz1 = new Raiz(1L, "Raiz A", classe1, true);
        Raiz raiz2 = new Raiz(1L, "Raiz B", classe2, false);
        Raiz raiz3 = new Raiz(2L, "Raiz A", classe1, true);

        Assertions.assertEquals(raiz1, raiz2);
        Assertions.assertEquals(raiz1.hashCode(), raiz2.hashCode());

        Assertions.assertNotEquals(raiz1, raiz3); 
        Assertions.assertNotEquals(raiz1.hashCode(), raiz3.hashCode()); 
    }
}






