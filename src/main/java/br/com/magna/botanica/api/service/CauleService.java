package br.com.magna.botanica.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.botanica.api.model.Caule;
import br.com.magna.botanica.api.record.DadosAtualizacaoPlanta;
import br.com.magna.botanica.api.record.DadosCadastroPlanta;
import br.com.magna.botanica.api.record.DadosListagemCaule;
import br.com.magna.botanica.api.repository.CauleRepository;

@Service
public class CauleService {

	@Autowired
	private CauleRepository cauleRepository;

	public Page<DadosListagemCaule> listagem( Pageable paginacao) {
    return cauleRepository.findAllByAtivoTrue(paginacao).map(DadosListagemCaule::new);
	}
	public Caule validandoDadosDeCaule(DadosCadastroPlanta dados) {
		return cauleRepository.validandoCauleComClasse(dados.cauleId(),dados.classeId());
	}
	public Caule validandoDadosCauleAtualizacao(DadosAtualizacaoPlanta dados) {
		return cauleRepository.validandoCauleComClasse(dados.cauleId(),dados.classeId());
	}
}


