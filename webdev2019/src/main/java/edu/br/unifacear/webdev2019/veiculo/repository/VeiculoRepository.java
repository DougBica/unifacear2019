package edu.br.unifacear.webdev2019.veiculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.veiculo.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
