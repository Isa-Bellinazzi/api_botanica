package br.com.magna.botanica.api.domain.raiz;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaizRepository extends JpaRepository<Raiz, Long>{

	Page<Raiz> findAllByAtivoTrue(Pageable paginacao);


}
