package br.com.magna.botanica.api.domain.filo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "filos")
@Entity(name = "Filo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public  class Filo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private Boolean folhas_verdadeiras;
	private Boolean caule_verdadeiro;
	private Boolean raiz_verdadeiras;
	private Boolean frutos;
	private Boolean flores;
	private Boolean ativo;
	private Boolean sementes;
}
