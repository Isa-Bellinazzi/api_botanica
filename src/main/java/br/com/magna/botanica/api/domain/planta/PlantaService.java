package br.com.magna.botanica.api.domain.planta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.botanica.api.domain.ValidacaoException;
import br.com.magna.botanica.api.domain.caule.CauleRepository;
import br.com.magna.botanica.api.domain.classe.Classe;
import br.com.magna.botanica.api.domain.classe.ClasseRepository;
import br.com.magna.botanica.api.domain.filo.FiloRepository;
import br.com.magna.botanica.api.domain.folhagem.FolhagemRepository;
import br.com.magna.botanica.api.domain.ordem.OrdemRepository;
import br.com.magna.botanica.api.domain.raiz.RaizRepository;

@Service
public class PlantaService {
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
	private FolhagemRepository folhaRepository;

	@Autowired
	private PlantaRepository repository;
	
	
	
	//@Autowired private ClasseService classeService;
	//todos os services que vai usar
	//repositoryClasse 
	
	public Planta cadastrar(DadosCadastroPlanta dados) {
		
		if(! classeRepository.existsById(dados.classe_id())){
			throw new ValidacaoException("Id inserido em classe é invalido");
		}
		if(! filoRepository.existsById(dados.filo_id())) {
			throw new ValidacaoException("Id inserido em filo é invalido");
		}
		if(dados.ordem_id() != null && ! ordemRepository.existsById(dados.ordem_id())) {
			throw new ValidacaoException("Id inserido em ordem é invalido");
		}
		if(! raizRepository.existsById(dados.raiz_id())) {
			throw new ValidacaoException("Id inserido em raiz é invalido");
		}
		if(! cauleRepository.existsById(dados.caule_id())) {
			throw new ValidacaoException("Id inserido em caule é invalido");
		}
		if(! folhaRepository.existsById(dados.folhagem_id())) {
			throw new ValidacaoException("Id inserido em folha é invalido");
		}
       var filo = filoRepository.getReferenceById(dados.filo_id());
       var classe = validandoDadosDeClasse(dados);
       var ordem = ordemRepository.findById(dados.ordem_id());
       var raiz = raizRepository.findById(dados.raiz_id());
	   var caule = cauleRepository.findById(dados.caule_id());
	   var folhagem = folhaRepository.findById(dados.folhagem_id());
		
		var planta = new Planta(null,dados.nome(),dados.cor(), filo,classe, ordem, raiz, caule, folhagem );
		repository.save(planta);

		return planta;
	}
	

	
	private Classe validandoDadosDeClasse(DadosCadastroPlanta dados) {
		
		return classeRepository.validandoClasseComFilo(dados.classe_id(),dados.filo_id());
	}



	public DadosDetalhamentoPlanta atualizar(DadosAtualizacaoPlanta dados) {
		var planta = repository.getReferenceById(dados.id());
		planta.atualizarInformacoes(dados);
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
