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

import br.com.magna.botanica.api.domain.classe.ClasseService;
import br.com.magna.botanica.api.domain.classe.DadosListagemClasse;
import br.com.magna.botanica.api.domain.filo.DadosDetalhamentoFilo;
import br.com.magna.botanica.api.domain.filo.DadosListagemFilo;
import br.com.magna.botanica.api.domain.filo.FiloRepository;
import br.com.magna.botanica.api.domain.filo.FiloService;

@RestController
@RequestMapping("filos")
public class FiloController {
	@Autowired
	private FiloService filoService;

	@GetMapping // METODO DE LISTAGEM
	public ResponseEntity<Page<DadosListagemFilo>> listar(
		@PageableDefault(size = 7, sort = { "descricao" }) Pageable paginacao) {
	    return ResponseEntity.ok(filoService.listagem(paginacao));
	}

	@GetMapping("/{id}") // Detalhamento de planta
	public ResponseEntity detalhar(@PathVariable Long id) {
		return ResponseEntity.ok(filoService.detalhar(id));

	}
}


