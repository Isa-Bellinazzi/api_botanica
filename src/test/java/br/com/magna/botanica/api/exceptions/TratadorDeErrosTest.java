package br.com.magna.botanica.api.exceptions;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.model.Planta;
import br.com.magna.botanica.api.record.DadosCadastroPlanta;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class TratadorDeErrosTest {
    @Autowired
    private  TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;


    @Test
    void testNotFound() {
		ResponseEntity<Planta> response = restTemplate.getForEntity("/listagem/999", Planta.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testValidationErrors() {
    	DadosCadastroPlanta dados = new DadosCadastroPlanta(null, "VERDE AZULADO", 2L, 4L, 5L, 2L, 2L, 4L);
		ResponseEntity<Object> response = restTemplate.postForEntity("/plantas/cadastrar", dados, Object.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testDataIntegrityViolation() {
    	DadosCadastroPlanta dados = new DadosCadastroPlanta("SAMAMBAIA", "VERDE AZULADO", 2L, 4L, 5L, 2L, 2L, 4L);
		ResponseEntity<Planta> response = restTemplate.postForEntity("/plantas/cadastrar", dados, Planta.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

}