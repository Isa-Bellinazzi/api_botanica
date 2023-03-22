package br.com.magna.botanica.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.botanica.api.model.Planta;
import br.com.magna.botanica.api.record.DadosAtualizacaoPlanta;
import br.com.magna.botanica.api.record.DadosCadastroPlanta;
import br.com.magna.botanica.api.record.DadosDetalhamentoPlanta;
import br.com.magna.botanica.api.record.DadosListagemPlanta;
import br.com.magna.botanica.api.record.DadosPlanta;
import br.com.magna.botanica.api.repository.FiloRepository;
import br.com.magna.botanica.api.repository.PlantaRepository;

@Service
public class PlantaService {
	@Autowired
	private PlantaRepository repository;
	@Autowired
	private FiloRepository filoRepository;
	@Autowired
	private ClasseService classeService;
	@Autowired
	private OrdemService ordemService;
	@Autowired
	private RaizService raizService;
	@Autowired
	private CauleService cauleService;
	@Autowired
	private FolhagemService folhagemService;
	
	public Planta cadastrar(DadosCadastroPlanta dados) {
		var filo = filoRepository.getReferenceById(dados.filoId());
		var classe = classeService.valiadandoDadosDeClasse(dados);
		var ordem = ordemService.validandoDadosDeOrdem(dados);
		var raiz = raizService.validandoDadosDeRaiz(dados);
		var caule = cauleService.validandoDadosDeCaule(dados);
		var folhagem = folhagemService.validandoDadosDeFolhagem(dados);
		var planta = new Planta(null, dados.nome(), dados.cor(), filo, classe, ordem, raiz, caule, folhagem, true);
		repository.save(planta);
		return planta;
	}

	public DadosDetalhamentoPlanta atualizar(DadosAtualizacaoPlanta dados) { 
		var nome = dados.nome();
		var cor = dados.cor();
		var filo = filoRepository.getReferenceById(dados.filoId());
		var classe = classeService.valiadandoDadosAtuliazacaoClasse(dados);
		var ordem = ordemService.validandoDadosAtualizacaoOrdem(dados);
		var raiz = raizService.validandoDadosRaizAtualizacao(dados);
		var caule = cauleService.validandoDadosCauleAtualizacao(dados);
		var folhagem = folhagemService.validandoDadosFolhagemAtualizacao(dados);
		var planta = repository.getReferenceById(dados.id());
		var dados1 = new DadosPlanta(nome,cor, filo, classe, ordem, raiz, caule, folhagem);
		planta.atualizarInformacoes(dados1);
		repository.save(planta);
		return new DadosDetalhamentoPlanta(planta);
	}

	public DadosDetalhamentoPlanta detalhar(Long id) {
		var planta = repository.getReferenceById(id);
		return new DadosDetalhamentoPlanta(planta);
	}

	public Page<DadosListagemPlanta> listagem(Pageable paginacao) {
		return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPlanta::new);
	}

	public void excluir(Long id) {
		var planta = repository.getReferenceById(id);
		planta.excluir();
	}
}
