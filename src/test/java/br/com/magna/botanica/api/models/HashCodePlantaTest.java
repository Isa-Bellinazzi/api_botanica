package br.com.magna.botanica.api.models;

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
class HashCodePlantaTest {

	    @Test
	    void testEqualsAndHashCode() {
	        Planta planta1 = new Planta(1L, "nome", "cor", new Filo(1L), new Classe(1L), new Ordem(1L), new Raiz(1L), new Caule(1L), new Folhagem(1L), true);
	        Planta planta2 = new Planta(1L, "nome", "cor", new Filo(1L), new Classe(1L), new Ordem(1L), new Raiz(1L), new Caule(1L), new Folhagem(1L), true);
	        Planta planta3 = new Planta(2L, "nome2", "cor2", new Filo(2L), new Classe(2L), new Ordem(2L), new Raiz(2L), new Caule(2L), new Folhagem(2L), false);

	        // Verifica se equals funciona corretamente
	        Assertions.assertEquals(planta1, planta2);
	        Assertions.assertNotEquals(planta1, planta3);

	        // Verifica se hashCode funciona corretamente
	        Assertions.assertEquals(planta1.hashCode(), planta2.hashCode());
	        Assertions.assertNotEquals(planta1.hashCode(), planta3.hashCode());
	    }
	}
