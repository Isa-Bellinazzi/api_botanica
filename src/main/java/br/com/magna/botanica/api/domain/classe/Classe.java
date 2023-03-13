package br.com.magna.botanica.api.domain.classe;

import br.com.magna.botanica.api.domain.filo.Filo;
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

@Table(name = "classes")
@Entity(name = "Classe")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Classe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	@OneToOne(targetEntity = Filo.class)
	@JoinColumn(name = "id_filo")
	private Filo idFilo;
	private Boolean ativo;

	public Classe(Long id) {
		this.id = id;
	}

	public Classe(String descricao, Filo idFilo, Boolean ativo) {
		this.descricao = descricao;
		this.idFilo = idFilo;
		this.ativo = ativo;
	}

}
