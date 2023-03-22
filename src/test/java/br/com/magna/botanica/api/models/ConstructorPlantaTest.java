package br.com.magna.botanica.api.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magna.botanica.api.model.Planta;
import br.com.magna.botanica.api.record.DadosCadastroPlanta;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
 class ConstructorPlantaTest {
    @Test
     void testConstructorPlanta() {
        // Cria um objeto DadosCadastroPlanta com valores de teste
        DadosCadastroPlanta dados = new DadosCadastroPlanta(
                "Planta Teste",
                "Azul",
                1L,
                1L,
                1L,
                2L,
                5L,
                5L
        );

        // Cria um objeto Planta com os dados de teste
        Planta planta = new Planta(dados);

        // Verifica se os dados foram corretamente setados no objeto Planta
        Assertions.assertEquals("Planta Teste", planta.getNome());
        Assertions.assertEquals("Azul", planta.getCor());
        Assertions.assertEquals(1L, planta.getIdFilo().getId());
        Assertions.assertEquals(1L, planta.getClasseId().getId());
        Assertions.assertEquals(1L, planta.getOrdemId().getId());
        Assertions.assertEquals(2L, planta.getRaizId().getId());
        Assertions.assertEquals(5L, planta.getCauleId().getId());
        Assertions.assertEquals(5L, planta.getFolhagemId().getId());
        Assertions.assertTrue(planta.getAtivo());
    }
}





