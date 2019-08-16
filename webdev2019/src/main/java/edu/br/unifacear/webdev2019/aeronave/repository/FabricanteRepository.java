package edu.br.unifacear.webdev2019.aeronave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.aeronave.entity.Fabricante;




public interface FabricanteRepository 
	extends JpaRepository<Fabricante, Long>{

}

