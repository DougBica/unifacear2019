package edu.br.unifacear.webdev2019.pontuacao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pontuacao")
public class Pontuacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidPontuacao;
	
	
	public Long getGuidPontuacao() {
		return guidPontuacao;
	}

	public void setGuidPontuacao(Long guidPontuacao) {
		this.guidPontuacao = guidPontuacao;
	}
}
