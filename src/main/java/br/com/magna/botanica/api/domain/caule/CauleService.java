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
	public DadosDetalhamentoCaule detalhar(Long id) {
		var caule = cauleRepository.getReferenceById(id);  
		return new DadosDetalhamentoCaule(caule);
	}
	public Page<DadosListagemCaule> listagem( Pageable paginacao) {
    var page = cauleRepository.findAllByAtivoTrue(paginacao).map(DadosListagemCaule::new);
    return page;
	}
	public Caule validandoDadosDeCaule(DadosCadastroPlanta dados) {
		return cauleRepository.validandoCauleComClasse(dados.cauleId(),dados.classeId());
	}
	public Caule validandoDadosCauleAtualizacao(DadosAtualizacaoPlanta dados) {
		return cauleRepository.validandoCauleComClasse(dados.cauleId(),dados.classeId());
	}
}


