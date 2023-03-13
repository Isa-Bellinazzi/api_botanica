package br.com.magna.botanica.api.domain.ordem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.com.magna.botanica.api.domain.planta.DadosAtualizacaoPlanta;
import br.com.magna.botanica.api.domain.planta.DadosCadastroPlanta;
@Service
public class OrdemService {
	@Autowired
	private OrdemRepository ordemRepository;
	
	public Page<DadosListagemOrdem> listagem( Pageable paginacao) {
	    return ordemRepository.findAllByAtivoTrue(paginacao).map(DadosListagemOrdem::new);
		}

	public Ordem validandoDadosDeOrdem(DadosCadastroPlanta dados) {
		return ordemRepository.validandoOrdemComClasse(dados.ordemId(), dados.classeId());
	}

	public Ordem validandoDadosAtualizacaoOrdem(DadosAtualizacaoPlanta dados) {
		return ordemRepository.validandoOrdemComClasse(dados.ordemId(), dados.classeId());
	}

}
