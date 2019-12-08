package edu.br.unifacear.webdev2019.checkin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BAGAGEM")
public class Bagagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidBagagem;
	private Double pesoBagagem;
	private String tokenBagagem;
	private boolean excesso;
	private Double valorexcesso;
	@Column(precision=10, scale=2)
	private Double valortotal;
	private Double valorbagagem;
	private Long guidCheckin;
	
	public Long getGuidCheckin() {
		return guidCheckin;
	}
	public void setGuidCheckin(Long guidCheckin) {
		this.guidCheckin = guidCheckin;
	}
	public Long getGuidBagagem() {
		return guidBagagem;
	}
	public void setGuidBagagem(Long guidBagagem) {
		this.guidBagagem = guidBagagem;
	}
	public Double getPesoBagagem() {
		return pesoBagagem;
	}
	public void setPesoBagagem(Double pesoBagagem) {
		this.pesoBagagem = pesoBagagem;
	}
	public String getTokenBagagem() {
		return tokenBagagem;
	}
	public void setTokenBagagem(String tokenBagagem) {
		this.tokenBagagem = tokenBagagem;
	}
	public boolean isExcesso() {
		return excesso;
	}
	public void setExcesso(boolean excesso) {
		this.excesso = excesso;
	}
	public Double getValorexcesso() {
		return valorexcesso;
	}
	public void setValorexcesso(Double valorexcesso) {
		this.valorexcesso = valorexcesso;
	}
	public Double getValortotal() {
		return valortotal;
	}
	public void setValortotal(Double valortotal) {
		this.valortotal = valortotal;
	}
	public Double getValorbagagem() {
		return valorbagagem;
	}
	public void setValorbagagem(Double valorbagagem) {
		this.valorbagagem = valorbagagem;
	}
	
}
