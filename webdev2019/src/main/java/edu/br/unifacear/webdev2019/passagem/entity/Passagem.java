package edu.br.unifacear.webdev2019.passagem.entity;

import java.sql.Timestamp;
import java.util.Date;

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
	
	private Date dataPartida;
	private boolean isActive;
	
	private double valorPassagem;
	
	
	
	public double getValorPassagem() {
		return valorPassagem;
	}
	public void setValorPassagem(double valorPassagem) {
		this.valorPassagem = valorPassagem;
	}
	public Date getDataPartida() {
		return dataPartida;
	}
	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
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
