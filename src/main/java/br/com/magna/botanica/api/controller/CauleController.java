package br.com.magna.botanica.api.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magna.botanica.api.record.DadosListagemCaule;
import br.com.magna.botanica.api.service.CauleService;

@RestController
@RequestMapping("caules")
public class CauleController {
	
	@Autowired
	private CauleService cauleService;
	
	@GetMapping(value = "/listagem") // METODO DE LISTAGEM
	public ResponseEntity<Page<DadosListagemCaule>> listar(
		@PageableDefault(size = 10, sort = { "descricao" }) Pageable paginacao) {
        return ResponseEntity.ok(cauleService.listagem(paginacao));
	}
}



