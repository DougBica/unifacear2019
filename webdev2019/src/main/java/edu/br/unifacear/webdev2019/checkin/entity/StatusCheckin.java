package edu.br.unifacear.webdev2019.checkin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STATUSCHECKIN")
public class StatusCheckin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long guidStatus;
	private String nomeStatus;
	private String corStatus;
	
	public Long getGuidStatus() {
		return guidStatus;
	}
	public void setGuidStatus(Long guidStatus) {
		this.guidStatus = guidStatus;
	}
	public String getNomeStatus() {
		return nomeStatus;
	}
	public void setNomeStatus(String nomeStatus) {
		this.nomeStatus = nomeStatus;
	}
	public String getCorStatus() {
		return corStatus;
	}
	public void setCorStatus(String corStatus) {
		this.corStatus = corStatus;
	}
		
}
