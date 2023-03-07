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
import br.com.magna.botanica.api.domain.folhagem.DadosDetalhamentoFolhagem;
import br.com.magna.botanica.api.domain.folhagem.DadosListagemFolhagem;
import br.com.magna.botanica.api.domain.folhagem.FolhagemRepository;
import br.com.magna.botanica.api.domain.folhagem.FolhagemService;
import br.com.magna.botanica.api.domain.raiz.DadosListagemRaiz;
import br.com.magna.botanica.api.domain.raiz.RaizService;

@RestController
@RequestMapping("folhagens")
public class FolhagemController {	
	@Autowired
	private FolhagemService folhagemService;

	@GetMapping // METODO DE LISTAGEM
	public ResponseEntity<Page<DadosListagemFolhagem>> listar(
		@PageableDefault(size = 7, sort = { "descricao" }) Pageable paginacao) {
	    return ResponseEntity.ok(folhagemService.listagem(paginacao));
	}

	@GetMapping("/{id}") // Detalhamento de planta
	public ResponseEntity detalhar(@PathVariable Long id) {
		return ResponseEntity.ok(folhagemService.detalhar(id));
	}
}


