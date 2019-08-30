package edu.br.unifacear.webdev2019.checkin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CHECKIN")
public class Checkin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long guidCheckin;
	@Column(nullable=false)
	private String token;
	private Long guidUsuario;
	@Column(nullable=false)
	private Long guidVoo;
	@Column(nullable=false)
	private Long guidPassagem;
	private Long guidAeronave;
	private boolean checkinAtivo;
	private boolean altaBagagem;
	private String fotoCheckin;
	private boolean indicadorFoto;
	private Long guidMilhagem;
	
	public Long getGuidMilhagem() {
		return guidMilhagem;
	}
	public void setGuidMilhagem(Long guidMilhagem) {
		this.guidMilhagem = guidMilhagem;
	}
	public boolean isIndicadorFoto() {
		return indicadorFoto;
	}
	public void setIndicadorFoto(boolean indicadorFoto) {
		this.indicadorFoto = indicadorFoto;
	}
	private Date dataCheckin;
	
	public Long getGuidCheckin() {
		return guidCheckin;
	}
	public void setGuidCheckin(Long guidCheckin) {
		this.guidCheckin = guidCheckin;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getGuidUsuario() {
		return guidUsuario;
	}
	public void setGuidUsuario(Long guidUsuario) {
		this.guidUsuario = guidUsuario;
	}
	public Long getGuidVoo() {
		return guidVoo;
	}
	public void setGuidVoo(Long guidVoo) {
		this.guidVoo = guidVoo;
	}
	public Long getGuidPassagem() {
		return guidPassagem;
	}
	public void setGuidPassagem(Long guidPassagem) {
		this.guidPassagem = guidPassagem;
	}
	public Long getGuidAeronave() {
		return guidAeronave;
	}
	public void setGuidAeronave(Long guidAeronave) {
		this.guidAeronave = guidAeronave;
	}
	public boolean isCheckinAtivo() {
		return checkinAtivo;
	}
	public void setCheckinAtivo(boolean checkinAtivo) {
		this.checkinAtivo = checkinAtivo;
	}
	public boolean isAltaBagagem() {
		return altaBagagem;
	}
	public void setAltaBagagem(boolean altaBagagem) {
		this.altaBagagem = altaBagagem;
	}
	public String getFotoCheckin() {
		return fotoCheckin;
	}
	public void setFotoCheckin(String fotoCheckin) {
		this.fotoCheckin = fotoCheckin;
	}
	public Date getDataCheckin() {
		return dataCheckin;
	}
	public void setDataCheckin(Date dataCheckin) {
		this.dataCheckin = dataCheckin;
	}
	
}
