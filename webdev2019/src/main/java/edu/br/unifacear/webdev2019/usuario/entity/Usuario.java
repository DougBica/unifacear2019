package edu.br.unifacear.webdev2019.usuario.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidUsuario;
	private String nome;
	private String email;
	private String senha;
	private String CPF;
	private Date DataNasc;
	private String Foto;
	
	@ManyToOne
	@JoinColumn(name = "guidTipoPerfil")
	private TipoPerfil perfil;

    @Enumerated(EnumType.STRING)
	private TipoUsuario tipoDeUsuario;
	
	public TipoUsuario getTipoDeUsuarios() {
		return tipoDeUsuario;
	}

	
	public TipoPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(TipoPerfil perfil) {
		this.perfil = perfil;
	}
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Date getDataNasc() {
		return DataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		DataNasc = dataNasc;
	}

	public String getFoto() {
		return Foto;
	}

	public void setFoto(String foto) {
		this.Foto = foto;
	}

	public void setTipoDeUsuarios(TipoUsuario tipoDeUsuarios) {
		this.tipoDeUsuario = tipoDeUsuarios;
	}

	public Long getGuidUsuario() {
		return guidUsuario;
	}

	public void setGuidUsuario(Long guidUsuario) {
		this.guidUsuario = guidUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
