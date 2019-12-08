package edu.br.unifacear.webdev2019.passagem.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "guidPassagem")
@Table(name = "PASSAGEM")
public class Passagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidPassagem;
	
	/*  
	 * Receive by Voo module.
	 * Rota object must contain a List<Voo>.
	 */
	@NotNull
	private Long guidRota; // this attibute shall be NOT NULL
	
	private boolean isKid;
	
	
	/*
	 * This Enum must contain in Aeroporto module
	 */
	@Enumerated(EnumType.STRING)	
    private ClassePassagemEnum classePassagem;
	
	@NotNull
	private Date dataPartida;
	
	@NotNull @NotEmpty
	private String origem;
	@NotNull @NotEmpty
	private String destino;
	
	/*
	 * If this attribute is true, the system shall allow the passenger to use the ticket
	 * Else the system must block this ticket and passenger can't use it
	 */
	private boolean active;
	
	private double valorPassagem;
	@NotNull @NotEmpty
	private String nomePassageiro; // this attibute shall be NOT NULL
	
	//@NotNull @NotEmpty @CPF
	private String cpfPassageiro; // This attribute shall be NULL
	
//	@ManyToOne
//	@JoinColumn(name = "guidReserva")
//	private Reserva reserva;
	
	@NotNull
	private Long guidReserva;
	
	
	
	public Long getGuidReserva() {
		return guidReserva;
	}


	public void setGuidReserva(Long guidReserva) {
		this.guidReserva = guidReserva;
	}


	public String getOrigem() {
		return origem;
	}


	public boolean isKid() {
		return isKid;
	}

	public void setKid(boolean isKid) {
		this.isKid = isKid;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}
	
//	public Reserva getReserva() {
//		return reserva;
//	}
//	public void setReserva(Reserva reserva) {
//		this.reserva = reserva;
//	}
	
	public Long getGuidPassagem() {
		return guidPassagem;
	}
	public void setGuidPassagem(Long guidPassagem) {
		this.guidPassagem = guidPassagem;
	}
	public Long getGuidRota() {
		return guidRota;
	}
	public void setGuidRota(Long guidRota) {
		this.guidRota = guidRota;
	}
	public ClassePassagemEnum getClassePassagem() {
		return classePassagem;
	}
	
	public void setClassePassagem(ClassePassagemEnum classePassagem) {
		this.classePassagem = classePassagem;
	}
	public Date getDataPartida() {
		return dataPartida;
	}
	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public double getValorPassagem() {
		return valorPassagem;
	}
	public void setValorPassagem(double valorPassagem) {
		this.valorPassagem = valorPassagem;
	}
	public String getNomePassageiro() {
		return nomePassageiro;
	}
	public void setNomePassageiro(String nomePassageiro) {
		this.nomePassageiro = nomePassageiro;
	}
	public String getCpfPassageiro() {
		return cpfPassageiro;
	}
	public void setCpfPassageiro(String cpfPassageiro) {
		this.cpfPassageiro = cpfPassageiro;
	}
}
