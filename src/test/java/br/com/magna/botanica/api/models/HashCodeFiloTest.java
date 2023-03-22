package br.com.magna.botanica.api.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.model.Filo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class HashCodeFiloTest {
    @Test
    void testEqualsAndHashCode() {
        Filo filo1 = new Filo(1L, "Filo A", true, true, true, true, true, true, true);
        Filo filo2 = new Filo(1L, "Filo B", false, false, false, false, false, false, false);
        Filo filo3 = new Filo(2L, "Filo A", true, true, true, true, true, true, true);

        Assertions.assertEquals(filo1, filo2); // Teste de igualdade
        Assertions.assertEquals(filo1.hashCode(), filo2.hashCode()); // Teste do hashCode

        Assertions.assertNotEquals(filo1, filo3); // Teste de desigualdade
        Assertions.assertNotEquals(filo1.hashCode(), filo3.hashCode()); // Teste do hashCode
    }
}





