package br.com.magna.botanica.api.repository;

import org.springframework.data.domain.Page; 
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magna.botanica.api.model.Planta;

public interface PlantaRepository extends JpaRepository<Planta, Long> {

	Page<Planta> findAllByAtivoTrue(Pageable paginacao);

}    
