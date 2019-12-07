package edu.br.unifacear.webdev2019.checkin.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMBARQUE")
public class Embarque {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long guidEmbarque;
	private boolean idntEmbarque;
	private Long guidCheckin;
	private Date dataEmbarque;
	private boolean embarcou;
	private String passageiro;
	private String embarcouIdf;
	
	public String getEmbarcouIdf() {
		return embarcouIdf;
	}
	public void setEmbarcouIdf(String embarcouIdf) {
		this.embarcouIdf = embarcouIdf;
	}
	public String getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(String passageiro) {
		this.passageiro = passageiro;
	}
	public boolean isEmbarcou() {
		return embarcou;
	}
	public void setEmbarcou(boolean embarcou) {
		this.embarcou = embarcou;
	}
	public Date getDataEmbarque() {
		return dataEmbarque;
	}
	public void setDataEmbarque(Date dataEmbarque) {
		this.dataEmbarque = dataEmbarque;
	}
	
	public Long getGuidEmbarque() {
		return guidEmbarque;
	}
	public void setGuidEmbarque(Long guidEmbarque) {
		this.guidEmbarque = guidEmbarque;
	}
	public boolean isIdntEmbarque() {
		return idntEmbarque;
	}
	public void setIdntEmbarque(boolean idntEmbarque) {
		this.idntEmbarque = idntEmbarque;
	}
	public Long getGuidCheckin() {
		return guidCheckin;
	}
	public void setGuidCheckin(Long guidCheckin) {
		this.guidCheckin = guidCheckin;
	}	
}
