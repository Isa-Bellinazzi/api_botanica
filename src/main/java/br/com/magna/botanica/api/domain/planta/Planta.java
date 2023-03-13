package br.com.magna.botanica.api.domain.planta;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.magna.botanica.api.domain.caule.Caule;
import br.com.magna.botanica.api.domain.classe.Classe;
import br.com.magna.botanica.api.domain.filo.Filo;
import br.com.magna.botanica.api.domain.folhagem.Folhagem;
import br.com.magna.botanica.api.domain.ordem.Ordem;
import br.com.magna.botanica.api.domain.raiz.Raiz;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "plantas")
@Entity(name = "Planta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
 public class Planta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
	private Long id;
    @JsonProperty("nome")
	private String nome;
    @JsonProperty("cor")
	private String cor;
	@OneToOne(targetEntity = Filo.class)
	@JoinColumn(name = "filo_id")
    @JsonProperty("filo")
	private Filo idFilo;
	@OneToOne(targetEntity = Classe.class)
	@JoinColumn(name = "classe_id")
    @JsonProperty("classe")
	private Classe classeId;
	@OneToOne(targetEntity = Ordem.class)
	@JoinColumn(name = "ordem_id")
    @JsonProperty("ordem")
	private Ordem ordemId;
	@OneToOne(targetEntity = Raiz.class)
	@JoinColumn(name = "raiz_id")
    @JsonProperty("raiz")
	private Raiz raizId;
	@OneToOne(targetEntity = Caule.class)
	@JoinColumn(name = "caule_id")
    @JsonProperty("caule")
	private Caule cauleId;
	@OneToOne(targetEntity = Folhagem.class)
	@JoinColumn(name = "folhagem_id")
    @JsonProperty("folhagem")
	private Folhagem folhagemId;
    @JsonProperty("ativo")
	private Boolean ativo;

	 void excluir() {
		this.ativo = false;
	}

	 Boolean getAtivo() {
	 	return ativo;
	}


	 Planta(DadosCadastroPlanta dados) {
			this.nome = dados.nome();
			this.cor = dados.cor();
			this.idFilo = new Filo(dados.filoId());
			this.classeId = new Classe(dados.classeId());
			this.ordemId = new Ordem(dados.ordemId());
			this.raizId = new Raiz(dados.raizId());
			this.cauleId = new Caule(dados.cauleId());
			this.folhagemId = new Folhagem(dados.folhagemId());
			this.ativo = true;
	}


	 public void atualizarInformacoes(DadosPlanta dadosPlanta) {
		    this.nome = dadosPlanta.nome();
		    this.cor = dadosPlanta.cor();
		    this.idFilo = dadosPlanta.filo();
		    this.classeId = dadosPlanta.classe();
		    this.ordemId = dadosPlanta.ordem();
		    this.raizId = dadosPlanta.raiz();
		    this.cauleId = dadosPlanta.caule();
		    this.folhagemId = dadosPlanta.folhagem();
		}

	
	
}
