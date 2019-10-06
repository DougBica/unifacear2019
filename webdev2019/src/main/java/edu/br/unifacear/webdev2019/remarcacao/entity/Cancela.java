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
@Table(name = "CANCELAR")
public class Cancela implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidCancelar;
	@NotNull
	private Long guidUsuario;
	@NotNull
	private Long guidReserva;
	@NotNull
	private Long guidPassagem;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataCancelamento;
	private String motivoCancelamento;


	public Long getGuidCancelar() {
		return guidCancelar;
	}
	
	public void setGuidCancelar(Long guidCancelar) {
		this.guidCancelar = guidCancelar;
	}
	
	public Date getDataCancelamento() {
		return dataCancelamento;
	}	
	
	public void setDataCancelamento(Date dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
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

	public String getMotivoCancelamento() {
		return motivoCancelamento;
	}

	public void setMotivoCancelamento(String motivoCancelamento) {
		this.motivoCancelamento = motivoCancelamento;
	}

}