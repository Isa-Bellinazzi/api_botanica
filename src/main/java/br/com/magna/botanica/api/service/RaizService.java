package br.com.magna.botanica.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.botanica.api.model.Raiz;
import br.com.magna.botanica.api.record.DadosAtualizacaoPlanta;
import br.com.magna.botanica.api.record.DadosCadastroPlanta;
import br.com.magna.botanica.api.record.DadosListagemRaiz;
import br.com.magna.botanica.api.repository.RaizRepository;
@Service
public class RaizService {
	@Autowired
	private RaizRepository raizRepository;
	
	public Page<DadosListagemRaiz> listagem( Pageable paginacao) {
    return raizRepository.findAllByAtivoTrue(paginacao).map(DadosListagemRaiz::new);
	}
	
	public Raiz validandoDadosDeRaiz(DadosCadastroPlanta dados) {
		return raizRepository.validandoRaizComClasse(dados.raizId(),dados.classeId());
	}
	public Raiz validandoDadosRaizAtualizacao(DadosAtualizacaoPlanta dados) {
		return raizRepository.validandoRaizComClasse(dados.raizId(),dados.classeId());
	}
}
