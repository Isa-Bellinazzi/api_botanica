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
import br.com.magna.botanica.api.domain.classe.ClasseRepository;
import br.com.magna.botanica.api.domain.classe.ClasseService;
import br.com.magna.botanica.api.domain.classe.DadosDetalhamentoClasse;
import br.com.magna.botanica.api.domain.classe.DadosListagemClasse;

@RestController
@RequestMapping("classes")
public class ClasseController {
	@Autowired
	private ClasseRepository repository;

	@Autowired
	private ClasseService classeService;

	@GetMapping // METODO DE LISTAGEM
	public ResponseEntity<Page<DadosListagemClasse>> listar(
			@PageableDefault(size = 7, sort = { "descricao" }) Pageable paginacao) {
	    return ResponseEntity.ok(classeService.listagem(paginacao));
	}
	@GetMapping("/{id}") // Detalhamento de planta
	public ResponseEntity detalhar(@PathVariable Long id) {
		return ResponseEntity.ok(classeService.detalhar(id));
	}

}