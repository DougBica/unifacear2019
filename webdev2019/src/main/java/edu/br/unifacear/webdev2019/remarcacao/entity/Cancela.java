package edu.br.unifacear.webdev2019.remarcacao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
<<<<<<< HEAD
import javax.validation.constraints.NotNull;
=======
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "CANCELAR")
public class Cancela implements Serializable{

	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long guidCancelar;
	@NotNull
	private Long guidUsuario;
	@NotNull
	private Long guidReserva;
	@NotNull
	private Long guidPassagem;
	private Boolean statusPassagem;
	private Boolean statusReserva;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataCancelamento;
 
=======

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long guidCancelar;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataCancelamento;
	
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
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
<<<<<<< HEAD

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

	public Boolean getStatusPassagem() {
		return statusPassagem;
	}

	public void setStatusPassagem(Boolean statusPassagem) {
		this.statusPassagem = statusPassagem;
	}

	public Boolean getStatusReserva() {
		return statusReserva;
	}

	public void setStatusReserva(Boolean statusReserva) {
		this.statusReserva = statusReserva;
	}

=======
	
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
}