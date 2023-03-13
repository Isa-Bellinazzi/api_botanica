package br.com.magna.botanica.api.planta;

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
import br.com.magna.botanica.api.domain.planta.Planta;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class PlantaDetalharTest {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testDetalhar() {
		ResponseEntity<Planta> response = restTemplate.getForEntity("/plantas/1", Planta.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals("SAMAMBAIA", response.getBody().getNome());
	}
}
	

