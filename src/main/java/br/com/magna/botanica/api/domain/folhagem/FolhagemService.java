package br.com.magna.botanica.api.domain.folhagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.botanica.api.domain.planta.DadosAtualizacaoPlanta;
import br.com.magna.botanica.api.domain.planta.DadosCadastroPlanta;
@Service
public class FolhagemService {
	@Autowired
	private FolhagemRepository folhaRepository;
	
	public DadosDetalhamentoFolhagem detalhar(Long id) {
		var folha = folhaRepository.getReferenceById(id);  
		return new DadosDetalhamentoFolhagem(folha);
	}
	public Page<DadosListagemFolhagem> listagem( Pageable paginacao) {
    var page = folhaRepository.findAllByAtivoTrue(paginacao).map(DadosListagemFolhagem::new);
    return page;
	}
	
	public Folhagem validandoDadosDeFolhagem(DadosCadastroPlanta dados) {
		return folhaRepository.validandoFolhaComClasse(dados.folhagemId(),dados.classeId());
	}
	
	public Folhagem validandoDadosFolhagemAtualizacao(DadosAtualizacaoPlanta dados) {
		return folhaRepository.validandoFolhaComClasse(dados.folhagemId(),dados.classeId());
	}
}
