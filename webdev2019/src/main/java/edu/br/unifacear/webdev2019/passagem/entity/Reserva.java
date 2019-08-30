package edu.br.unifacear.webdev2019.passagem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVA")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidReserva;
	private String guidUsuario;
	
	private String origem;
	private String destino;
	
	private Double valorReserva; // This attribute is defined with the Passagem values
	private boolean itsPaid; //True or false 
	
	private boolean isActive; // If false -> cancel Reserva
	
//	@OneToMany
//	@JoinColumn(name = "guidPassagem")
//	private List<Passagem> passagens;
//	
//	@OneToOne
//	@JoinColumn(name = "guidPagamento")
//	private Pagamento pagamento;
	
	
	public Long getGuidReserva() {
		return guidReserva;
	}
	public void setGuidReserva(Long guidReserva) {
		this.guidReserva = guidReserva;
	}
	public String getGuidUsuario() {
		return guidUsuario;
	}
	public void setGuidUsuario(String guidUsuario) {
		this.guidUsuario = guidUsuario;
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
	public Double getValorReserva() {
		return valorReserva;
	}
	public void setValorReserva(Double valorReserva) {
		this.valorReserva = valorReserva;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Long getGuidPassagem() {
		return guidReserva;
	}
	public void setGuidPassagem(Long guidReserva) {
		this.guidReserva = guidReserva;
	}
	public String getClassePassagem() {
		return guidUsuario;
	}
	public void setClassePassagem(String guidUsuario) {
		this.guidUsuario = guidUsuario;
	}
}
