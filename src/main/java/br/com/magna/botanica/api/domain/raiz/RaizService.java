package br.com.magna.botanica.api.domain.raiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.magna.botanica.api.domain.planta.DadosAtualizacaoPlanta;
import br.com.magna.botanica.api.domain.planta.DadosCadastroPlanta;
@Service
public class RaizService {
	@Autowired
	private RaizRepository raizRepository;
	
	public DadosDetalhamentoRaiz detalhar(Long id) {
		var raiz = raizRepository.getReferenceById(id);  
		return new DadosDetalhamentoRaiz(raiz);
	}
	public Page<DadosListagemRaiz> listagem( Pageable paginacao) {
    var page = raizRepository.findAllByAtivoTrue(paginacao).map(DadosListagemRaiz::new);
    return page;
	}
	
	public Raiz validandoDadosDeRaiz(DadosCadastroPlanta dados) {
		return raizRepository.validandoRaizComClasse(dados.raizId(),dados.classeId());
	}
	public Raiz validandoDadosRaizAtualizacao(DadosAtualizacaoPlanta dados) {
		return raizRepository.validandoRaizComClasse(dados.raizId(),dados.classeId());
	}
}
