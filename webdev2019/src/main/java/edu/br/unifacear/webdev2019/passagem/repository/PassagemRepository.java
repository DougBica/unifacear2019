package edu.br.unifacear.webdev2019.passagem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.br.unifacear.webdev2019.passagem.entity.Passagem;

public interface PassagemRepository 
extends JpaRepository<Passagem, Long>{

	Passagem findByClasse(String classe);
	
	@Query("select p from Passagem p where guidPassagem like %:guiPassagem% and classePassagem like %:classePassagem% ")
	public List<Passagem> findByClasseAndGuid(@Param ("guiPassagem") Long guiPassagem,@Param ("classePassagem") String classePassagem);
}
