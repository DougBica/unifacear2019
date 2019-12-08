package edu.br.unifacear.webdev2019.passagem.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
	
	@NotNull
	private BigDecimal valorReserva; // This attribute is defined with the Passagem values
	
	private boolean paid; // its paid?
	
	private boolean active; // its active?
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoPagamentoEnum tipoPagamento;
	
	
	public Reserva() {
		
	}
	public Reserva(Long guidUsuario,List<Passagem> listaPassagens) {
		this.guidUsuario = guidUsuario;
		double valorTotal = listaPassagens.stream().mapToDouble(passagem -> passagem.getValorPassagem()).sum();
		this.valorReserva = BigDecimal.valueOf(valorTotal);
		this.paid = true;
		this.active = true;
		this.tipoPagamento = tipoPagamento.CARTAO;
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
