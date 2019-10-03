package edu.br.unifacear.webdev2019.veiculo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOCAR")
public class Locar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidLocar;
	private Long veiculoId;
	private String localretirada;
	private String localdevolucao;
	private String dataretirada;
	private String datadevolucao;
	private Integer pagamento;
	
	public String getLocalretirada() {
		return localretirada;
	}
	public void setLocalretirada(String localretirada) {
		this.localretirada = localretirada;
	}
	public String getLocaldevolucao() {
		return localdevolucao;
	}
	public void setLocaldevolucao(String localdevolucao) {
		this.localdevolucao = localdevolucao;
	}
	public String getDataretirada() {
		return dataretirada;
	}
	public void setDataretirada(String dataretirada) {
		this.dataretirada = dataretirada;
	}
	public String getDatadevolucao() {
		return datadevolucao;
	}
	public void setDatadevolucao(String datadevolucao) {
		this.datadevolucao = datadevolucao;
	}

	public Long getGuidLocar() {
		return guidLocar;
	}
	public void setGuidLocar(Long guidLocar) {
		this.guidLocar = guidLocar;
	}
	public Long getVeiculoId() {
		return veiculoId;
	}
	public void setVeiculoId(Long veiculoId) {
		this.veiculoId = veiculoId;
	}
	public Integer getPagamento() {
		return pagamento;
	}
	public void setPagamento(Integer pagamento) {
		this.pagamento = pagamento;
	}
	
	

}
