package br.com.magna.botanica.api.planta;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.domain.planta.DadosAtualizacaoPlanta;
import br.com.magna.botanica.api.domain.planta.DadosDetalhamentoPlanta;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class PlantaAtualizacaoTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testAtualizar() {
		DadosAtualizacaoPlanta dados = new DadosAtualizacaoPlanta(5L, "PINHEIRO", "CASTANHO", 4L, 10L, 19L,
				5L, 4L, 10L);
		ResponseEntity<DadosDetalhamentoPlanta> response = restTemplate.exchange("/plantas/atualizar", HttpMethod.PUT,
				new HttpEntity<>(dados), DadosDetalhamentoPlanta.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals("PINHEIRO", response.getBody().nome());
	}
}
