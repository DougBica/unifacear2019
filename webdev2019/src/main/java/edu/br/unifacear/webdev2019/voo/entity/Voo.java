package edu.br.unifacear.webdev2019.voo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "VOO")
public class Voo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidVoo; // ID Voo
	private String origem; // Cidade de Origem
	private String destino; // Cidade de Destino
	private String kmtotal; // Km Total
	private String datasaida; // Data Saída
	private String datachegada; // Data Chegada
	private String duracao; // Duração do Voo

	public Long getGuidVoo() {
		return guidVoo;
	}

	public void setGuidVoo(Long guidVoo) {
		this.guidVoo = guidVoo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getKmtotal() {
		return kmtotal;
	}

	public void setKmtotal(String kmtotal) {
		this.kmtotal = kmtotal;
	}

	public String getDatasaida() {
		return datasaida;
	}

	public void setDatasaida(String datasaida) {
		this.datasaida = datasaida;
	}

	public String getDatachegada() {
		return datachegada;
	}

	public void setDatachegada(String datachegada) {
		this.datachegada = datachegada;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

}