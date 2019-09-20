package edu.br.unifacear.webdev2019.passagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.passagem.entity.TipoPagamento;

public interface TipoPagamentoRepository 
extends JpaRepository<TipoPagamento, Long>{

}