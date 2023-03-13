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
	private Boolean folhasVerdadeiras;
	private Boolean cauleVerdadeiro;
	private Boolean raizVerdadeiras;
	private Boolean frutos;
	private Boolean flores;
	private Boolean ativo;
	private Boolean sementes;
	
    public Filo(Long id) {
        this.id = id;
    }

    public Filo(DadosDetalhamentoFilo dados) {
        this.descricao = dados.descricao();
        this.folhasVerdadeiras = dados.folhasVerdadeiras();
        this.cauleVerdadeiro = dados.cauleVerdadeiro();
        this.raizVerdadeiras = dados.raizVerdadeiras();
        this.frutos = dados.frutos();
        this.flores = dados.flores();
        this.ativo = dados.ativo();
        this.sementes = dados.sementes();
    }
}

