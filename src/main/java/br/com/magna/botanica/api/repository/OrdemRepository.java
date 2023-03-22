package br.com.magna.botanica.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.botanica.api.model.Ordem;

public interface OrdemRepository extends JpaRepository<Ordem, Long>{

	Page<Ordem> findAllByAtivoTrue(Pageable paginacao);

	
	@Query("""
			SELECT o FROM Ordem o
			WHERE
			(o.ativo = true)
			and
			(o.id = :idOrdem)
			and
			(o.classeId.id = :classeId)
			""")
	Ordem validandoOrdemComClasse(Long idOrdem, Long classeId);


}
