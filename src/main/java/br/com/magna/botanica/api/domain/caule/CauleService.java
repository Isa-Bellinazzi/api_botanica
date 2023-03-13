package br.com.magna.botanica.api.domain.caule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magna.botanica.api.domain.planta.DadosAtualizacaoPlanta;
import br.com.magna.botanica.api.domain.planta.DadosCadastroPlanta;

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


