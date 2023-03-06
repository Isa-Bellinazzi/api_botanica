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

import br.com.magna.botanica.api.domain.caule.CauleRepository;
import br.com.magna.botanica.api.domain.caule.CauleService;
import br.com.magna.botanica.api.domain.caule.DadosListagemCaule;

@RestController
@RequestMapping("caules")
public class CauleController {
	@Autowired
	private CauleRepository repository;
	
	@Autowired
	private CauleService cauleService;
	
	@GetMapping // METODO DE LISTAGEM
	public ResponseEntity<Page<DadosListagemCaule>> listar(
			@PageableDefault(size = 7, sort = { "descricao" }) Pageable paginacao) {
        return ResponseEntity.ok(cauleService.listagem(paginacao));
	}
	@GetMapping("/{id}") // Detalhamento de planta
	public ResponseEntity detalhar(@PathVariable Long id) {
		return ResponseEntity.ok(cauleService.detalhar(id));
	}
}



