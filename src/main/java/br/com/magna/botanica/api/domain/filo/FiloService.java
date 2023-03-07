package br.com.magna.botanica.api.domain.filo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FiloService {
	@Autowired
	private FiloRepository filoRepository;
	
	public DadosDetalhamentoFilo detalhar(Long id) {
		var filo = filoRepository.getReferenceById(id);  
		return new DadosDetalhamentoFilo(filo);
	}
	public Page<DadosListagemFilo> listagem( Pageable paginacao) {
	var page = filoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemFilo::new);
	return page;
	}
}
