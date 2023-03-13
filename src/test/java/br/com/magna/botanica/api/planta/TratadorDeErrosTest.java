package br.com.magna.botanica.api.planta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.domain.caule.Caule;
import br.com.magna.botanica.api.domain.planta.DadosCadastroPlanta;
import br.com.magna.botanica.api.domain.planta.Planta;
import br.com.magna.botanica.api.infra.TratadorDeErros.DadosErroValidacao;
import jakarta.persistence.EntityNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class TratadorDeErrosTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
     void tratarErro404() {
        ResponseEntity<List<EntityNotFoundException>> response = restTemplate.exchange(
            "/tratarErro404",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EntityNotFoundException>>() {}
        );
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
     void tratarErro400() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("invalidField", "");

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<List<DadosErroValidacao>> response = restTemplate.exchange(
            "/tratarErro400",
            HttpMethod.POST,
            request,
            new ParameterizedTypeReference<List<DadosErroValidacao>>() {}
        );
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals("invalidField", response.getBody().get(0).campo());
        assertEquals("must not be blank", response.getBody().get(0).mensagem());
    }

    @Test
     void tratarErro500() {
		DadosCadastroPlanta dados = new DadosCadastroPlanta("SAMAMBAIA", "VERDE AZULADO", 3L, 6L, 17L, 8L, 8L, 8L);
		ResponseEntity<Planta> responses = restTemplate.postForEntity("/plantas", dados, Planta.class);
		Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responses.getStatusCode());

        ResponseEntity<List<DadosErroValidacao>> response = restTemplate.exchange(
            "/tratarErro500",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<DadosErroValidacao>>() {}
        );
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertNull(response.getBody().get(0).campo());
        assertNotNull(response.getBody().get(0).mensagem());
    }

}