package edu.br.unifacear.webdev2019.voo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PARADA")
public class Parada {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidAeroporto; // Identificação do Aeroporto
	private Integer numeroParada; // Número de Paradas
	private Long guidVoo; // Identificação do Voo
	
	public Long getGuidAeroporto() {
		return guidAeroporto;
	}
	public void setGuidAeroporto(Long guidAeroporto) {
		this.guidAeroporto = guidAeroporto;
	}
	public Integer getNumeroParada() {
		return numeroParada;
	}
	public void setNumeroParada(Integer numeroParada) {
		this.numeroParada = numeroParada;
	}
	public Long getGuidVoo() {
		return guidVoo;
	}
	public void setGuidVoo(Long guidVoo) {
		this.guidVoo = guidVoo;
	}
}
