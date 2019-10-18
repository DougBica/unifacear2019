package edu.br.unifacear.webdev2019.voo.entity;
/*
 	A rota mostrará "possibilidades" de Origem e Destino para que o cliente possa escolher qual será sua Rota. 
 */


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROTA")
public class Rota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidRota; // Identificação da Rota
	private String origem; // Cidade de Origem
	private String destino; // Cidade de Destino	
	//private List<Parada> paradas; // Lista de Parada
	
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
	public long getGuidRota() {
		return guidRota;
	}
	public void setGuidRota(long guidRota) {
		this.guidRota = guidRota;
	}
	/*public List<Parada> getParadas() {
		return paradas;
	}
	public void setParadas(List<Parada> paradas) {
		this.paradas = paradas;
	}*/
}
