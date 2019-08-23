package edu.br.unifacear.webdev2019.aeronave.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ASENTO")

public class Assento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidassento;
	private Long qtdassento;
	
	public Long getGuidassento() {
		return guidassento;
	}
	public void setGuidassento(Long guidassento) {
		this.guidassento = guidassento;
	}
	public Long getQtdassento() {
		return qtdassento;
	}
	public void setQtdassento(Long qtdassento) {
		this.qtdassento = qtdassento;
	}
	
	
	
	
	
}
