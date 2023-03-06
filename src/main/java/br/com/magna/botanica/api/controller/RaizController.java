package br.com.magna.botanica.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.magna.botanica.api.domain.raiz.DadosDetalhamentoRaiz;
import br.com.magna.botanica.api.domain.raiz.DadosListagemRaiz;
import br.com.magna.botanica.api.domain.raiz.RaizRepository;

@RestController
@RequestMapping("raizes")
public class RaizController {
	@Autowired
	private RaizRepository repository;

	@GetMapping // METODO DE LISTAGEM
	public ResponseEntity<Page<DadosListagemRaiz>> listar(
			@PageableDefault(size = 7, sort = { "descricao" }) Pageable paginacao) {
		var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemRaiz::new);
		return ResponseEntity.ok(page);
	}
	@GetMapping("/{id}") // Detalhamento de planta
	public ResponseEntity detalhar(@PathVariable Long id) {
		var raiz = repository.getReferenceById(id);
		return ResponseEntity.ok(new DadosDetalhamentoRaiz(raiz));

	}
}


