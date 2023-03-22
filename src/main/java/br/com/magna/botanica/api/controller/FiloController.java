package br.com.magna.botanica.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.botanica.api.record.DadosListagemFilo;
import br.com.magna.botanica.api.service.FiloService;

@RestController
@RequestMapping("filos")
public class FiloController {
	@Autowired
	private FiloService filoService;

	@GetMapping(value = "/listagem") // METODO DE LISTAGEM
	public ResponseEntity<Page<DadosListagemFilo>> listar(
		@PageableDefault(size = 7, sort = { "descricao" }) Pageable paginacao) {
	    return ResponseEntity.ok(filoService.listagem(paginacao));
	}

}


