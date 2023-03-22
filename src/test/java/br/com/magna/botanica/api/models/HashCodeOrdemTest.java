package br.com.magna.botanica.api.models;

import static org.assertj.core.api.Assertions.assertThat;

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
class HashCodeOrdemTest {

	@Test
	void testEquals() {
		Classe classe1 = new Classe(1L, "Classe 1", null, true);
		Ordem ordem1 = new Ordem(1L, "Ordem 1", classe1, true);
		Ordem ordem2 = new Ordem(2L, "Ordem 1", classe1, true);
		assertThat(ordem1).isNotEqualTo(ordem2);
	}
}
