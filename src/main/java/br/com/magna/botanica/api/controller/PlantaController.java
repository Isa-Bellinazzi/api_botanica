package br.com.magna.botanica.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.magna.botanica.api.domain.planta.DadosAtualizacaoPlanta;
import br.com.magna.botanica.api.domain.planta.DadosCadastroPlanta;
import br.com.magna.botanica.api.domain.planta.DadosDetalhamentoPlanta;
import br.com.magna.botanica.api.domain.planta.DadosListagemPlanta;
import br.com.magna.botanica.api.domain.planta.Planta;
import br.com.magna.botanica.api.domain.planta.PlantaRepository;
import br.com.magna.botanica.api.domain.planta.PlantaService;

@RestController
@RequestMapping("plantas")
public class PlantaController {
	@Autowired
	private PlantaRepository repository;

	@Autowired
	private PlantaService plantaService;

	@PostMapping
	@Transactional // METODO DE CADASTRO
	
	 public ResponseEntity cadastrar(@RequestBody @Validated DadosCadastroPlanta
	 dados, UriComponentsBuilder uriBuilder) { var planta =
	 plantaService.cadastrar(dados); var uri =
	 uriBuilder.path("/planta/{id}").buildAndExpand(planta.getId()).toUri();
	 return ResponseEntity.created(uri).body(plantaService.detalhar(planta.getId())); }

	@GetMapping // METODO DE LISTAGEM
	public ResponseEntity<Page<DadosListagemPlanta>> listar(
			@PageableDefault(size = 7, sort = { "nome" }) Pageable paginacao) {
		return ResponseEntity.ok(plantaService.listagem(paginacao));
	}

	@PutMapping
	@Transactional // METODO DE ATUALIZAÇÃO
	public ResponseEntity atualizar(@RequestBody @Validated DadosAtualizacaoPlanta dados) {
		return ResponseEntity.ok(plantaService.atualizar(dados));

	}

	/*
	 * @DeleteMapping("/{id}")
	 * 
	 * @Transactional // EXCLUSAO FISICA public ResponseEntity excluir(@PathVariable
	 * Long id){ repository.deleteById(id); return
	 * ResponseEntity.noContent().build();
	 * 
	 * }
	 */

	@DeleteMapping("/{id}")
	@Transactional // EXCLUSAO LOGICA
	public ResponseEntity excluir(@PathVariable Long id) {
		plantaService.excluir(id);
		return ResponseEntity.noContent().build();

	}

	@GetMapping("/{id}") // Detalhamento de planta
	public ResponseEntity detalhar(@PathVariable Long id) {
		return ResponseEntity.ok(plantaService.detalhar(id));

	}
}
