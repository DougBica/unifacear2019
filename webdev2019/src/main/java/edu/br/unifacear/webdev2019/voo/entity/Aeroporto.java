package edu.br.unifacear.webdev2019.voo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AEROPORTO")
public class Aeroporto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidAeroporto; // ID Aeroporto
	private String nome; // Nome Aeroporto
	private String sigla; // Sigla Aeroporto
	private String cidade; // Cidade de Localização do Aeroporto
	private String estado; // Estado de Localização do Aeroporto
	private String pais; // Pais de Localização do Aeroporto

	public Long getGuidAeroporto() {
		return guidAeroporto;
	}

	public void setGuidAeroporto(Long guidAeroporto) {
		this.guidAeroporto = guidAeroporto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
