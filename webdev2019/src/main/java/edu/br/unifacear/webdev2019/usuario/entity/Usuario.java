package edu.br.unifacear.webdev2019.usuario.entity;

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
import javax.persistence.OneToMany;
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
	private String login;
	
	@ElementCollection
    @CollectionTable(name = "TIPO_USUARIOS",joinColumns = @JoinColumn(name = "guidUsuario") ,  foreignKey=@ForeignKey(name = "FK_USUARIO_ROLES"))
    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
	@Fetch(FetchMode.SUBSELECT)
	private List<TipoUsuario> TipoDeUsuarios;
	
	
	public List<TipoUsuario> getTipoDeUsuarios() {
		return TipoDeUsuarios;
	}

	public void setTipoDeUsuarios(List<TipoUsuario> tipoDeUsuarios) {
		TipoDeUsuarios = tipoDeUsuarios;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
