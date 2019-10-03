package edu.br.unifacear.webdev2019.aeronave.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.aeronave.entity.Assento;

public interface AssentoRepository

		extends JpaRepository<Assento, Long> {

	List<Assento> findAllByGuidAeronave(Long guidAeronave);

}
