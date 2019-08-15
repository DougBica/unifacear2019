package edu.br.unifacear.webdev2019.compraPassagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.compraPassagem.entity.Passagem;

public interface PassagemRepository 
extends JpaRepository<Passagem, Long>{


}
