package br.com.magna.botanica.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.botanica.api.model.Folhagem;
import br.com.magna.botanica.api.record.DadosAtualizacaoPlanta;
import br.com.magna.botanica.api.record.DadosCadastroPlanta;
import br.com.magna.botanica.api.record.DadosListagemFolhagem;
import br.com.magna.botanica.api.repository.FolhagemRepository;
@Service
public class FolhagemService {
	@Autowired
	private FolhagemRepository folhaRepository;
	
	public Page<DadosListagemFolhagem> listagem( Pageable paginacao) {
    return folhaRepository.findAllByAtivoTrue(paginacao).map(DadosListagemFolhagem::new);
	}
	
	public Folhagem validandoDadosDeFolhagem(DadosCadastroPlanta dados) {
		return folhaRepository.validandoFolhaComClasse(dados.folhagemId(),dados.classeId());
	}
	
	public Folhagem validandoDadosFolhagemAtualizacao(DadosAtualizacaoPlanta dados) {
		return folhaRepository.validandoFolhaComClasse(dados.folhagemId(),dados.classeId());
	}
}
