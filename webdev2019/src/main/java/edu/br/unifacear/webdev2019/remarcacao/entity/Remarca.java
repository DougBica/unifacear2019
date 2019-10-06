package edu.br.unifacear.webdev2019.remarcacao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "REMARCAR")
public class Remarca implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidRemarcar;
	@NotNull
	private Long guidUsuario;
	@NotNull
	private Long guidReserva;
	@NotNull
	private Long guidPassagem;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataRemarcacao;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataPassagemAntiga;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataPassagemNova;
	
	public Long getGuidRemarcar() {
		return guidRemarcar;
	}
	
	public void setGuidRemarcar(Long guidRemarcar) {
		this.guidRemarcar = guidRemarcar;
	}
	
	public Date getDataRemarcacao() {
		return dataRemarcacao;
	}
	
	public void setDataRemarcacao(Date dataRemarcacao) {
		this.dataRemarcacao = dataRemarcacao;
	}

	public Long getGuidUsuario() {
		return guidUsuario;
	}

	public void setGuidUsuario(Long guidUsuario) {
		this.guidUsuario = guidUsuario;
	}

	public Long getGuidReserva() {
		return guidReserva;
	}

	public void setGuidReserva(Long guidReserva) {
		this.guidReserva = guidReserva;
	}

	public Long getGuidPassagem() {
		return guidPassagem;
	}

	public void setGuidPassagem(Long guidPassagem) {
		this.guidPassagem = guidPassagem;
	}

	public Date getDataPassagemAntiga() {
		return dataPassagemAntiga;
	}

	public void setDataPassagemAntiga(Date dataPassagemAntiga) {
		this.dataPassagemAntiga = dataPassagemAntiga;
	}

	public Date getDataPassagemNova() {
		return dataPassagemNova;
	}

	public void setDataPassagemNova(Date dataPassagemNova) {
		this.dataPassagemNova = dataPassagemNova;
	}
}