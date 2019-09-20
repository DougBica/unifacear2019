package edu.br.unifacear.webdev2019.passagem.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name = "TipoPagamento")
public class TipoPagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidTipoPagamento;
	
	@NotEmpty
	private String descricaoPagamento;
	
	@OneToMany(mappedBy="tipoPagamento",fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Reserva> reserva;

	public Long getGuidTipoPagamento() {
		return guidTipoPagamento;
	}
	
	public void setGuidTipoPagamento(Long guidTipoPagamento) {
		this.guidTipoPagamento = guidTipoPagamento;
	}

	public String getDescricaoPagamento() {
		return descricaoPagamento;
	}

	public void setDescricaoPagamento(String descricaoPagamento) {
		this.descricaoPagamento = descricaoPagamento;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}
	
	
	
	
}
