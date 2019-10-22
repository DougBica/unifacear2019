package edu.br.unifacear.webdev2019.remarcacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.remarcacao.entity.Cancela;

public interface CancelaRepository extends JpaRepository<Cancela, Long>{
	
	Cancela findByGuidUsuario(Long guidUsuario);
	
	List<Cancela> findByGuidReserva(Long guidReserva);
	
	Cancela findByGuidPassagem(Long guidPassagem);	
}
