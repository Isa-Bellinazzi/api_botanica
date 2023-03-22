package br.com.magna.botanica.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.magna.botanica.api.model.Caule;

public interface CauleRepository extends JpaRepository<Caule, Long>{

	Page<Caule> findAllByAtivoTrue(Pageable paginacao);

	@Query("""
			SELECT ca FROM Caule ca
			WHERE
			(ca.ativo = true)
			and
			(ca.id = :cauleId)
			and
			(ca.classeId.id = :idClasse)
			""")
	Caule validandoCauleComClasse(Long cauleId, Long idClasse);


}
