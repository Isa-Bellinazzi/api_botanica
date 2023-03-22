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
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class PlantaExcluirTest {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testExcluir() {
		restTemplate.delete("/plantas/excluir/6");
		ResponseEntity<Planta> response = restTemplate.getForEntity("/excluir/6", Planta.class);
		Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
}
