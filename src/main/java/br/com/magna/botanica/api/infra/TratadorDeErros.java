package br.com.magna.botanica.api.infra;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<List<EntityNotFoundException>> tratarErro404() {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<DadosErroValidacao>> tratarErro400(MethodArgumentNotValidException ex) {
		return tratarErro(ex.getFieldErrors(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<List<DadosErroValidacao>> tratarErro500(DataIntegrityViolationException ex) {
		return tratarErro(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<List<DadosErroValidacao>> tratarErro(List<FieldError> erros, HttpStatus status) {
		var dadosErrosValidacao = erros.stream().map(TratadorDeErros::criarDadosErroValidacao).toList();

		return ResponseEntity.status(status).body(dadosErrosValidacao);
	}

	private ResponseEntity<List<DadosErroValidacao>> tratarErro(String mensagem, HttpStatus status) {
		var dadosErrosValidacao = List.of(new DadosErroValidacao(null, mensagem));

		return ResponseEntity.status(status).body(dadosErrosValidacao);
	}

	private static DadosErroValidacao criarDadosErroValidacao(FieldError erro) {
		return new DadosErroValidacao(erro.getField(), erro.getDefaultMessage());
	}

	public record DadosErroValidacao(String campo, String mensagem) {
	}

}