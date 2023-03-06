package br.com.magna.botanica.api.domain.ordem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemRepository extends JpaRepository<Ordem, Long>{

	Page<Ordem> findAllByAtivoTrue(Pageable paginacao);


}
