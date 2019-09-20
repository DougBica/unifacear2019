package edu.br.unifacear.webdev2019.veiculo.entity;

import javax.persistence.Column;
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
	
	@Column(name="guidusuario",nullable = false)
	private Long guidUsuario;
	
	private String placa;
	private String chassis;
	private Integer renavam;
	private String marca;
	private String modelo;
	private String cor;
	private Integer ano;
	private Integer combustivel;
	private Integer grupo;
	private Float valordiaria;
	private Float coberturaveiculo;
	private Float coberturaterceiros;
	
	

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

	public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public Integer getRenavam() {
		return renavam;
	}

	public void setRenavam(Integer renavam) {
		this.renavam = renavam;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Integer combustivel) {
		this.combustivel = combustivel;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Float getValordiaria() {
		return valordiaria;
	}

	public void setValordiaria(Float valordiaria) {
		this.valordiaria = valordiaria;
	}

	public Float getCoberturaveiculo() {
		return coberturaveiculo;
	}

	public void setCoberturaveiculo(Float coberturaveiculo) {
		this.coberturaveiculo = coberturaveiculo;
	}

	public Float getCoberturaterceiros() {
		return coberturaterceiros;
	}

	public void setCoberturaterceiros(Float coberturaterceiros) {
		this.coberturaterceiros = coberturaterceiros;
	}

	public Integer getGrupo() {
		return grupo;
	}

	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}

}
