package br.com.magna.botanica.api.domain.classe;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.magna.botanica.api.domain.caule.Caule;
import br.com.magna.botanica.api.domain.caule.CauleRepository;
import br.com.magna.botanica.api.domain.filo.Filo;
import br.com.magna.botanica.api.domain.filo.FiloRepository;
import br.com.magna.botanica.api.domain.folhagem.Folhagem;
import br.com.magna.botanica.api.domain.folhagem.FolhagemRepository;
import br.com.magna.botanica.api.domain.ordem.Ordem;
import br.com.magna.botanica.api.domain.ordem.OrdemRepository;
import br.com.magna.botanica.api.domain.planta.Planta;
import br.com.magna.botanica.api.domain.planta.PlantaRepository;
import br.com.magna.botanica.api.domain.raiz.Raiz;
import br.com.magna.botanica.api.domain.raiz.RaizRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class ClasseRepositoryTest {
	@Autowired
	private FiloRepository filoRepository;

	@Autowired
	private ClasseRepository classeRepository;

	@Autowired
	private OrdemRepository ordemRepository;

	@Autowired
	private RaizRepository raizRepository;

	@Autowired
	private CauleRepository cauleRepository;

	@Autowired
	private FolhagemRepository folhagemRepository;

	@Autowired
	private PlantaRepository plantaRepository;

	@Test
	@DisplayName("Verifica se o id eh o mesmo")
	void validandoClasseComFilo() {
		String nome = "Bananeira";
		String cor = "amarela";
		Filo filo = new Filo(1L, "Angiosperma", true, true, true, true, true, true, true);
		Classe classe = new Classe(1L, "EUDICOTILEDONEA",filo,true);
		Ordem ordem = new Ordem(1L, "ASTERACEAE",classe,true);
		Raiz raiz = new Raiz(7L, "PIVOTANTE",classe,true);
		Caule caule = new Caule(7L, "CILINDRICO",classe,true);
		Folhagem folha = new Folhagem(2L, "RETICULADA",classe,true);
		Planta planta = new Planta(nome, cor, filo, classe, ordem, raiz, caule, folha);
		plantaRepository.save(planta);

		Optional<Classe> classes = classeRepository.findById(1L);
		var validaId = classes.get().getIdFilo().getId();
		Assertions.assertEquals(1L, validaId);

	}
}