package br.com.magna.botanica.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.botanica.api.record.DadosListagemFolhagem;
import br.com.magna.botanica.api.service.FolhagemService;

@RestController
@RequestMapping("folhagens")
 class FolhagemController {	
	@Autowired
	private FolhagemService folhagemService;

	@GetMapping(value = "/listagem") // METODO DE LISTAGEM
	 ResponseEntity<Page<DadosListagemFolhagem>> listar(
		@PageableDefault(size = 7, sort = { "descricao" }) Pageable paginacao) {
	    return ResponseEntity.ok(folhagemService.listagem(paginacao));
	}
}


