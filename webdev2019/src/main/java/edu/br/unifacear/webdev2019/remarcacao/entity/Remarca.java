package edu.br.unifacear.webdev2019.remarcacao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REMARCAR")
public class Remarca implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long guidRemarcar;
	private Date dataRemarcacao;
	
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
	
}