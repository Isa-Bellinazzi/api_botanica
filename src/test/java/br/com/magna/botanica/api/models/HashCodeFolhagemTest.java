package br.com.magna.botanica.api.models;

import static org.assertj.core.api.Assertions.assertThat;
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
class HashCodeFolhagemTest {

	@Test
	void testEqualsAndHashCode() {
		Folhagem folhagem1 = new Folhagem(1L, "Folhagem 1", new Classe(1L), true);
		Folhagem folhagem3 = new Folhagem(2L, "Folhagem 1", new Classe(1L), true);

		assertThat(folhagem1).isNotEqualTo(folhagem3);
		assertThat(folhagem1.hashCode()).isNotEqualTo(folhagem3.hashCode());
	}
}
