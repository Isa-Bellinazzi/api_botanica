package br.com.magna.botanica.api.record;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.record.DadosDetalhamentoFilo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
 class DadosDetalhamentoFiloTest {

    @Test
     void testCarregarDadosDetalhamentoFilo() {
        String descricao = "Lorem ipsum dolor sit amet";
        Boolean folhasVerdadeiras = true;
        Boolean cauleVerdadeiro = true;
        Boolean raizVerdadeiras = true;
        Boolean frutos = true;
        Boolean flores = true;
        Boolean ativo = true;
        Boolean sementes = true;
        DadosDetalhamentoFilo dados = new DadosDetalhamentoFilo(descricao, folhasVerdadeiras, cauleVerdadeiro, raizVerdadeiras, frutos, flores, ativo, sementes);
        assertNotNull(dados);
        assertEquals(descricao, dados.descricao());
        assertEquals(folhasVerdadeiras, dados.folhasVerdadeiras());
        assertEquals(cauleVerdadeiro, dados.cauleVerdadeiro());
        assertEquals(raizVerdadeiras, dados.raizVerdadeiras());
        assertEquals(frutos, dados.frutos());
        assertEquals(flores, dados.flores());
        assertEquals(ativo, dados.ativo());
        assertEquals(sementes, dados.sementes());
    }
}