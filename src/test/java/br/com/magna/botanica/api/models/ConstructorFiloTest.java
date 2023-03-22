package br.com.magna.botanica.api.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.magna.botanica.api.model.Filo;
import br.com.magna.botanica.api.record.DadosDetalhamentoFilo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ConstructorFiloTest {
    @Test
     void testFiloConstructorWithId() {
        Long id = 1L;
        Filo filo = new Filo(id);
        assertEquals(id, filo.getId());
        assertNull(filo.getDescricao());
        assertNull(filo.getFolhasVerdadeiras());
        assertNull(filo.getCauleVerdadeiro());
        assertNull(filo.getRaizVerdadeiras());
        assertNull(filo.getFrutos());
        assertNull(filo.getFlores());
        assertNull(filo.getSementes());
        assertNull(filo.getAtivo());
    }

    @Test
     void testFiloConstructorWithDadosDetalhamentoFilo() {
        DadosDetalhamentoFilo dados = new DadosDetalhamentoFilo(
        		"Filo Test",
        		true,
        		true,
        		true,
        		true,
        		true,
        		true,
        		true);
  

        Filo filo = new Filo(dados);
        assertEquals(dados.descricao(), filo.getDescricao());
        assertEquals(dados.folhasVerdadeiras(), filo.getFolhasVerdadeiras());
        assertEquals(dados.cauleVerdadeiro(), filo.getCauleVerdadeiro());
        assertEquals(dados.raizVerdadeiras(), filo.getRaizVerdadeiras());
        assertEquals(dados.frutos(), filo.getFrutos());
        assertEquals(dados.flores(), filo.getFlores());
        assertEquals(dados.ativo(), filo.getAtivo());
        assertEquals(dados.sementes(), filo.getSementes());
    }
}