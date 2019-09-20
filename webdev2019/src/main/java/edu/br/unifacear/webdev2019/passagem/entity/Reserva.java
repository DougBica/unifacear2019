package edu.br.unifacear.webdev2019.passagem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RESERVA")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidReserva;

	private Long guidUsuario;
	
	private String origem;
	private String destino;
	
	private Double valorReserva; // This attribute is defined with the Passagem values
	
	private boolean paid; // its paid?
	
	private boolean active; // its active?
	
	@ManyToOne
	@JoinColumn(name="guidTipoPagamento")
		private TipoPagamento tipoPagamento;
	
	@ManyToOne
	@JoinColumn(name="guidPassagem")
	private Passagem passagem; 
	
	
		

	public Passagem getPassagem() {
		return passagem;
	}

	public void setPassagem(Passagem passagem) {
		this.passagem = passagem;
	}

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
