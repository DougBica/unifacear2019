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

import com.fasterxml.jackson.annotation.JsonFormat;
=======
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2

@Entity
@Table(name = "REMARCAR")
public class Remarca implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long guidRemarcar;
<<<<<<< HEAD
	@NotNull
	private Long guidUsuario;
	@NotNull
	private Long guidReserva;
	@NotNull
	private Long guidPassagem;
	private Boolean statusReserva;
	private Boolean statusPassagem;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataPassagem;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataRemarcacao;
	
	
=======
	private Date dataRemarcacao;
	
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
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

	public Boolean getStatusReserva() {
		return statusReserva;
	}

	public void setStatusReserva(Boolean statusReserva) {
		this.statusReserva = statusReserva;
	}

	public Boolean getStatusPassagem() {
		return statusPassagem;
	}

	public void setStatusPassagem(Boolean statusPassagem) {
		this.statusPassagem = statusPassagem;
	}

	public Date getDataPassagem() {
		return dataPassagem;
	}

	public void setDataPassagem(Date dataPassagem) {
		this.dataPassagem = dataPassagem;
	}
=======
>>>>>>> 34cd681d7cf53a9473b4dbdcb59526b567c402f2
	
}