package edu.br.unifacear.webdev2019.passagem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PASSAGEM")
public class Passagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidPassagem;
	private String classePassagem;
	
	public Long getGuidPassagem() {
		return guidPassagem;
	}
	public void setGuidPassagem(Long guidPassagem) {
		this.guidPassagem = guidPassagem;
	}
	public String getClassePassagem() {
		return classePassagem;
	}
	public void setClassePassagem(String classePassagem) {
		this.classePassagem = classePassagem;
	}
}
