package edu.br.unifacear.webdev2019.passagem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RESERVA")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidReserva;
	@NotNull
	private String guidUsuario;
	
//	@OneToMany
//	@JoinColumn(name = "guidPassagem")
//	private List<Passagem> passagens;
//	
//	@OneToOne
//	@JoinColumn(name = "guidPagamento")
//	private Pagamento pagamento;
	
	
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
