package edu.br.unifacear.webdev2019.checkin.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMBARQUE")
public class Embarque implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long guidEmbarque;
	private boolean idntEmbarque;
	@OneToOne
	@JoinColumn(name="guidCheckin")
	private Checkin checkin;
	
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
	public Checkin getCheckin() {
		return checkin;
	}
	public void setCheckin(Checkin checkin) {
		this.checkin = checkin;
	}
	
}
