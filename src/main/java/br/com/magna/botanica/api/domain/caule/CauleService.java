package br.com.magna.botanica.api.domain.caule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CauleService {
	@Autowired
	private CauleRepository repository;
	public DadosDetalhamentoCaule detalhar(Long id) {
		var caule = repository.getReferenceById(id);  
		return new DadosDetalhamentoCaule(caule);
	}
	public Page<DadosListagemCaule> listagem( Pageable paginacao) {
    var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemCaule::new);
    return page;
	}
}


