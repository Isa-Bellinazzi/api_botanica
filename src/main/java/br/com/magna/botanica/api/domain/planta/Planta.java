package br.com.magna.botanica.api.domain.planta;

import java.util.Optional;

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
import jakarta.persistence.ManyToOne;
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
public class Planta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cor;
	@OneToOne(targetEntity = Filo.class)
	@JoinColumn(name = "filo_id")
	private Filo idFilo;
	@OneToOne(targetEntity = Classe.class)
	@JoinColumn(name = "classe_id")
	private Classe classeId;
	@OneToOne(targetEntity = Ordem.class)
	@JoinColumn(name = "ordem_id")
	private Ordem ordemId;
	@OneToOne(targetEntity = Raiz.class)
	@JoinColumn(name = "raiz_id")
	private Raiz raizId;
	@OneToOne(targetEntity = Caule.class)
	@JoinColumn(name = "caule_id")
	private Caule cauleId;
	@OneToOne(targetEntity = Folhagem.class)
	@JoinColumn(name = "folhagem_id")
	private Folhagem folhagemId;
	private Boolean ativo;

	public void excluir() {
		this.ativo = false;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public Planta(String nome, String cor, Filo filo, Classe classe, Ordem ordem, Raiz raiz, Caule caule,
			Folhagem folhagem) {
		this.nome = nome;
		this.cor = cor;
		this.idFilo = filo;
		this.classeId = classe;
		this.ordemId = ordem;
		this.raizId = raiz;
		this.cauleId = caule;
		this.folhagemId = folhagem;
		this.ativo = true;
	}


	public void atualizarInformacoes(Long id, String nome, String cor, Filo filo, Classe classe, Ordem ordem, Raiz raiz, Caule caule,
			Folhagem folhagem) {
		this.id = id;
		this.nome = nome;
		this.cor = cor;
		this.idFilo = filo;
		this.classeId = classe;
		this.ordemId = ordem;
		this.raizId = raiz;
		this.cauleId = caule;
		this.folhagemId = folhagem;
		this.ativo = true;
	}
	
	
}
