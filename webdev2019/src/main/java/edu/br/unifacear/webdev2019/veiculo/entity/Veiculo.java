package edu.br.unifacear.webdev2019.veiculo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEICULO")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidVeiculo;
	private String placa;

	public Long getGuidVeiculo() {
		return guidVeiculo;
	}

	public void setGuidVeiculo(Long guidVeiculo) {
		this.guidVeiculo = guidVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
