package edu.br.unifacear.webdev2019.aeronave.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FABRICANTE")

public class Fabricante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidFabricante;
	private String nomefabricante;
	
	
	public Long getGuidFabricante() {
		return guidFabricante;
	}
	public void setGuidFabricante(Long guidFabricante) {
		this.guidFabricante = guidFabricante;
	}
	public String getNomefabricante() {
		return nomefabricante;
	}
	public void setNomefabricante(String nomefabricante) {
		this.nomefabricante = nomefabricante;
	}
	

	
	
	
	


}
