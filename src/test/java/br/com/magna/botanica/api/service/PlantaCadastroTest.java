package br.com.magna.botanica.api.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.model.Planta;
import br.com.magna.botanica.api.record.DadosCadastroPlanta;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class PlantaCadastroTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testCadastrar() {
		DadosCadastroPlanta dados = new DadosCadastroPlanta("ANDREAEIDAE", "VERDE AZULADO", 2L, 4L, 5L, 2L, 2L, 4L);
		ResponseEntity<Planta> response = restTemplate.postForEntity("/plantas/cadastrar", dados, Planta.class);
		Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
		Assert.assertEquals("ANDREAEIDAE", response.getBody().getNome());
	}
}
