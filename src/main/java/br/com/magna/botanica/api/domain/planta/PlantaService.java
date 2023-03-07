package br.com.magna.botanica.api.domain.planta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.botanica.api.domain.caule.CauleService;
import br.com.magna.botanica.api.domain.classe.ClasseService;
import br.com.magna.botanica.api.domain.filo.FiloRepository;
import br.com.magna.botanica.api.domain.folhagem.FolhagemService;
import br.com.magna.botanica.api.domain.ordem.OrdemService;
import br.com.magna.botanica.api.domain.raiz.RaizService;

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
	   var folhagem = folhagemService.validandoDadosDeFolhagem(dados);;
	   var planta = new Planta(dados.nome(),dados.cor(), filo,classe, 
	   ordem, raiz, caule, folhagem);
	   repository.save(planta);
	   return planta;
	}

	public DadosDetalhamentoPlanta atualizar(DadosAtualizacaoPlanta dados) {
		var filo = filoRepository.getReferenceById(dados.filoId());
	    var classe = classeService.valiadandoDadosAtuliazacaoClasse(dados);
	    var ordem = ordemService.validandoDadosAtualizacaoOrdem(dados);
	    var raiz = raizService.validandoDadosRaizAtualizacao(dados);
		var caule = cauleService.validandoDadosCauleAtualizacao(dados);
		var folhagem = folhagemService.validandoDadosFolhagemAtualizacao(dados);;
		var planta = repository.getReferenceById(dados.id());
		planta.atualizarInformacoes(dados.id(),dados.nome(),dados.cor(),
		filo,classe, ordem, raiz, caule, folhagem);
		repository.save(planta);
		return new DadosDetalhamentoPlanta(planta);
	}
	
	public DadosDetalhamentoPlanta detalhar(Long id) {
		var planta = repository.getReferenceById(id);  
		return new DadosDetalhamentoPlanta(planta);
	}
	
	public Page<DadosListagemPlanta> listagem( Pageable paginacao) {
    var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPlanta::new);
    return page;
	}
	
	public void excluir(Long id) {
		var planta = repository.getReferenceById(id);
		planta.excluir();
	}
}
