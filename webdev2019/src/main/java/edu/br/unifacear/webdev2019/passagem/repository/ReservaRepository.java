package edu.br.unifacear.webdev2019.passagem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.passagem.entity.Reserva;

public interface ReservaRepository 
extends JpaRepository<Reserva, Long>{

	List<Reserva> findByGuidUsuario(Long guidUsuairo);

}
