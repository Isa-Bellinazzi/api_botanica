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
	 
	
	public Planta cadastrar(DadosCadastroPlanta dados) {
		if(! classeRepository.existsById(dados.classeId())){
			throw new ValidacaoException("Id inserido em classe é invalido");
		}
		if(! filoRepository.existsById(dados.filoId())) {
			throw new ValidacaoException("Id inserido em filo é invalido");
		}
		if(dados.ordemId() != null && ! ordemRepository.existsById(dados.ordemId())) {
			throw new ValidacaoException("Id inserido em ordem é invalido");
		}
		if(! raizRepository.existsById(dados.raizId())) {
			throw new ValidacaoException("Id inserido em raiz é invalido");
		}
		if(! cauleRepository.existsById(dados.cauleId())) {
			throw new ValidacaoException("Id inserido em caule é invalido");
		}
		if(! folhaRepository.existsById(dados.folhagemId())) {
			throw new ValidacaoException("Id inserido em folha é invalido");
		}
       var filo = filoRepository.getReferenceById(dados.filoId());
       var classe = validandoDadosDeClasse(dados);
       //var classe = classeRepository.getReferenceById(dados.classeId());
       var ordem = ordemRepository.getReferenceById(dados.ordemId());
       var raiz = raizRepository.getReferenceById(dados.raizId());
	   var caule = cauleRepository.getReferenceById(dados.cauleId());
	   var folhagem = folhaRepository.getReferenceById(dados.folhagemId());
		
		var planta = new Planta(dados.nome(),dados.cor(), filo,classe, ordem, raiz, caule, folhagem);
		repository.save(planta);

		return planta;
	}

	private Classe validandoDadosDeClasse(DadosCadastroPlanta dados) {
		
		return classeRepository.validandoClasseComFilo(dados.classeId(),dados.filoId());
	}



	public DadosDetalhamentoPlanta atualizar(DadosAtualizacaoPlanta dados) {
		if(! classeRepository.existsById(dados.classeId())){
			throw new ValidacaoException("Id inserido em classe é invalido");
		}
		if(! filoRepository.existsById(dados.filoId())) {
			throw new ValidacaoException("Id inserido em filo é invalido");
		}
		if(dados.ordemId() != null && ! ordemRepository.existsById(dados.ordemId())) {
			throw new ValidacaoException("Id inserido em ordem é invalido");
		}
		if(! raizRepository.existsById(dados.raizId())) {
			throw new ValidacaoException("Id inserido em raiz é invalido");
		}
		if(! cauleRepository.existsById(dados.cauleId())) {
			throw new ValidacaoException("Id inserido em caule é invalido");
		}
		if(! folhaRepository.existsById(dados.folhagemId())) {
			throw new ValidacaoException("Id inserido em folha é invalido");
		}
       var filo = filoRepository.getReferenceById(dados.filoId());
       var classe = classeRepository.getReferenceById(dados.classeId());
       var ordem = ordemRepository.getReferenceById(dados.ordemId());
       var raiz = raizRepository.getReferenceById(dados.raizId());
	   var caule = cauleRepository.getReferenceById(dados.cauleId());
	   var folhagem = folhaRepository.getReferenceById(dados.folhagemId());
		var planta = repository.getReferenceById(dados.id());
		planta.atualizarInformacoes(dados.id(),dados.nome(),dados.cor(), filo,classe, ordem, raiz, caule, folhagem);
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
