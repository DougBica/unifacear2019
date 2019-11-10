package edu.br.unifacear.webdev2019.arquivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.arquivo.entity.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {

}
