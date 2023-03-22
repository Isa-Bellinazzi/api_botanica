package br.com.magna.botanica.api.record;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.record.DadosInformacoesAtualizacaoPlanta;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
 class DadosInformacoesAtualizacaoPlantaTest {
	 @Test
	     void testCarregarDadosInformacoes() {
	        Long filoId = 1L;
	        Long classeId = 2L;
	        Long ordemId = 3L;
	        Long raizId = 4L;
	        Long cauleId = 5L;
	        Long folhagemId = 6L;
	        DadosInformacoesAtualizacaoPlanta dados = new DadosInformacoesAtualizacaoPlanta(filoId, classeId, ordemId, raizId, cauleId, folhagemId);
	        assertNotNull(dados);
	        assertEquals(filoId, dados.filoId());
	        assertEquals(classeId, dados.classeId());
	        assertEquals(ordemId, dados.ordemId());
	        assertEquals(raizId, dados.raizId());
	        assertEquals(cauleId, dados.cauleId());
	        assertEquals(folhagemId, dados.folhagemId());
	    }
	}