package edu.br.unifacear.webdev2019.checkin.entity;

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
