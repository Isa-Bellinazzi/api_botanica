package br.com.magna.botanica.api.domain.folhagem;

import br.com.magna.botanica.api.domain.classe.Classe;

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

@Table(name = "folhagens")
@Entity(name = "Folhagem")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Folhagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	@OneToOne(targetEntity = Classe.class)
	@JoinColumn(name = "classe_id")
	private Classe classeId;
	private Boolean ativo;

	public Folhagem(Long id) {
		this.id = id;
	}

	public Folhagem(String descricao, Classe classeId, Boolean ativo) {
		this.descricao = descricao;
		this.classeId = classeId;
		this.ativo = ativo;
	}
}
