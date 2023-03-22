package br.com.magna.botanica.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.botanica.api.model.Filo;

public interface FiloRepository extends JpaRepository<Filo, Long>{

	Page<Filo> findAllByAtivoTrue(Pageable paginacao);


}
