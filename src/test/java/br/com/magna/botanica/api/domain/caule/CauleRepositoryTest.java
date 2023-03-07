package br.com.magna.botanica.api.domain.caule;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import br.com.magna.botanica.api.domain.classe.Classe;
import br.com.magna.botanica.api.domain.filo.Filo;
import br.com.magna.botanica.api.domain.folhagem.Folhagem;
import br.com.magna.botanica.api.domain.ordem.Ordem;
import br.com.magna.botanica.api.domain.planta.DadosCadastroPlanta;
import br.com.magna.botanica.api.domain.planta.Planta;
import br.com.magna.botanica.api.domain.raiz.Raiz;

/*@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CauleRepositoryTest {
	@Autowired
	private CauleRepository cauleRepository;

	@Autowired
	private TestEntityManager em;

	@Test
	@DisplayName("Deveria devolver null quando unico medico cadastrado nao esta disponivel na data")
	void validandoCauleComClasse() {
		var cauleInvalido= cauleRepository.validandoCauleComClasse(cauleId, idClasse);
	     assertThat(cauleInvalido).isNull();
	}
	private Planta cadastrar(String nome, String cor, Filo filoId, Classe classeId, 
		Ordem ordemId, Raiz raizId, Caule cauleId, Folhagem folhagemId) {
	    var planta = new Planta(nome, cor, filoId, classeId,ordemId,raizId,cauleId,folhagemId);
	    em.persist(planta);
	    return planta;
	}
	private DadosCadastroPlanta teste(String nome, String cor, Long filoId, Long classeId, 
			Long ordemId, Long raizId, Long cauleId, Long folhagemId) {
	    return new DadosCadastroPlanta(nome,cor,1,4,1,7,7,1);
	}
}*/