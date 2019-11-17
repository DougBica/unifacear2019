package edu.br.unifacear.webdev2019.passagem.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "guidReserva")
@Table(name = "RESERVA")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidReserva;

	@NotNull
	private Long guidUsuario;
	
	
	private BigDecimal valorReserva; // This attribute is defined with the Passagem values
	
	private boolean paid; // its paid?
	
	private boolean active; // its active?
	
	@OneToOne
	@JoinColumn(name="guidTipoPagamento")
	private TipoPagamento tipoPagamento;
	
//	@OneToMany
//	@JoinColumn(name="guidPassagem")
//	private List<Passagem> passagem; 
	
	
		
//
//	public List<Passagem> getPassagem() {
//		return this.passagem;
//	}
//
//	public void setPassagem(List<Passagem> passagem) {
//		this.passagem = passagem;
//	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Long getGuidReserva() {
		return guidReserva;
	}

	public void setGuidReserva(Long guidReserva) {
		this.guidReserva = guidReserva;
	}

	public Long getGuidUsuario() {
		return guidUsuario;
	}

	public void setGuidUsuario(Long guidUsuario) {
		this.guidUsuario = guidUsuario;
	}


	public BigDecimal getValorReserva() {
		return valorReserva;
	}

	public void setValorReserva(BigDecimal valorReserva) {
		this.valorReserva = valorReserva;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
//	@OneToMany
//	@JoinColumn(name = "guidPassagem")
//	private List<Passagem> passagens;
//	
//	@OneToOne
//	@JoinColumn(name = "guidPagamento")
//	private Pagamento pagamento;
	
	
	
}
