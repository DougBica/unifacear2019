package edu.br.unifacear.webdev2019.aeronave.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ASSENTO")

public class Assento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidassento;
	@Column(name = "guidaeronave", nullable = false)
	private Long guidAeronave;
	private Long qtdassento;
	@Enumerated(EnumType.STRING)
	private Classe classe;

	public Long getGuidassento() {
		return guidassento;
	}

	public void setGuidassento(Long guidassento) {
		this.guidassento = guidassento;
	}

	public Long getGuidAeronave() {
		return guidAeronave;
	}

	public void setGuidAeronave(Long guidAeronave) {
		this.guidAeronave = guidAeronave;
	}

	public Long getQtdassento() {
		return qtdassento;
	}

	public void setQtdassento(Long qtdassento) {
		this.qtdassento = qtdassento;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}
