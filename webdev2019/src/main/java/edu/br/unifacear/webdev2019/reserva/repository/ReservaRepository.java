package edu.br.unifacear.webdev2019.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.reserva.entity.Reserva;

public interface ReservaRepository 
extends JpaRepository<Reserva, Long>{

}
