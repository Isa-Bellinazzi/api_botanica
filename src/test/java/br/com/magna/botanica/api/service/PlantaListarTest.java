package br.com.magna.botanica.api.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.model.Caule;
import br.com.magna.botanica.api.model.Classe;
import br.com.magna.botanica.api.model.Filo;
import br.com.magna.botanica.api.model.Folhagem;
import br.com.magna.botanica.api.model.Ordem;
import br.com.magna.botanica.api.model.Planta;
import br.com.magna.botanica.api.model.Raiz;
import br.com.magna.botanica.api.repository.PlantaRepository;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class PlantaListarTest {
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private PlantaRepository repository;

	@Test
	void testListar() {
		String riccia = "RICCIA";
		String corRiccia = "VERDE";
		Filo briofita = new Filo(2L, "BRIOFITA", false, false, false, false, false, false, true);
		Classe marchantiophyta = new Classe(5L, "MARCHANTIOPHYTA", briofita, true);
		Ordem hepatica = new Ordem(6L, "HEPATICA", marchantiophyta, true);
		Raiz rizoides = new Raiz(3L, "RIZOIDES", marchantiophyta, true);
		Caule cauloide = new Caule(3L, "CAULOIDE", marchantiophyta, true);
		Folhagem filoides = new Folhagem(5L, "FILOIDES", marchantiophyta, true);
		repository.save(new Planta(null, riccia, corRiccia, briofita,
		marchantiophyta, hepatica, rizoides, cauloide,filoides, true));
		ResponseEntity<String> response = restTemplate.exchange("/plantas/listagem?page=0&size=10", 
		HttpMethod.GET,null, String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertNotNull(response.getBody());
		Assert.assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
	}
}