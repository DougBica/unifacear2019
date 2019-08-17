package edu.br.unifacear.webdev2019.remarcacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.remarcacao.entity.Cancela;

public interface CancelaRepository extends JpaRepository<Cancela, Long>{
	
}
