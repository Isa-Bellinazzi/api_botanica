package br.com.magna.botanica.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.botanica.api.model.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Long>{

	Page<Classe> findAllByAtivoTrue(Pageable paginacao);

	@Query("""
			SELECT  c FROM Classe c
			WHERE
			(c.ativo = true)
			and
			(c.id = :classeId)
			and
			(c.idFilo.id = :idFilo)
			""")
	Classe validandoClasseComFilo(Long classeId, Long idFilo);


}
