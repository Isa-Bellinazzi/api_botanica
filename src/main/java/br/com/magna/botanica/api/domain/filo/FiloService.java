package br.com.magna.botanica.api.domain.filo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FiloService {
	@Autowired
	private FiloRepository filoRepository;

	public Page<DadosListagemFilo> listagem( Pageable paginacao) {
	return filoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemFilo::new);
	}
}
