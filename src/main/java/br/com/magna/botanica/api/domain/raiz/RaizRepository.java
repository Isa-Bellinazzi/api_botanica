package br.com.magna.botanica.api.domain.raiz;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RaizRepository extends JpaRepository<Raiz, Long>{

	Page<Raiz> findAllByAtivoTrue(Pageable paginacao);

	@Query("""
			SELECT r FROM Raiz r
			WHERE
			(r.ativo = true)
			and
			(r.id = :raizId)
			and
			(r.classeId.id = :classeId)			
			""")
	Raiz validandoRaizComClasse(Long raizId, Long classeId);

	
	
	


}
