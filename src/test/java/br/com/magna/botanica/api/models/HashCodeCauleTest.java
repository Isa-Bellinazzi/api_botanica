package br.com.magna.botanica.api.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class HashCodeCauleTest {
	   @Test
	    void testEqualsAndHashCode() {
	        Classe classe1 = new Classe(1L);
	        Classe classe2 = new Classe(2L);

	        Caule caule1 = new Caule(1L, "Caule A", classe1, true);
	        Caule caule2 = new Caule(1L, "Caule B", classe2, false);
	        Caule caule3 = new Caule(2L, "Caule A", classe1, true);

	        Assertions.assertEquals(caule1, caule2); // Teste de igualdade
	        Assertions.assertEquals(caule1.hashCode(), caule2.hashCode()); // Teste do hashCode

	        Assertions.assertNotEquals(caule1, caule3); // Teste de desigualdade
	        Assertions.assertNotEquals(caule1.hashCode(), caule3.hashCode()); // Teste do hashCode
	    }
	}
