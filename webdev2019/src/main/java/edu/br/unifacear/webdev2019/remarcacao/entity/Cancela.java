package edu.br.unifacear.webdev2019.remarcacao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "CANCELAR")
public class Cancela implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long guidCancelar;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataCancelamento;
	
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
	
}