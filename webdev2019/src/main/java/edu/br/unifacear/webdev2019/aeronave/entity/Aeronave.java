package edu.br.unifacear.webdev2019.aeronave.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "AERONAVE")

public class Aeronave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guidaeronave;
	private String nomeaeronave;
	private Long comprimento;
	private Long envergadura;
	private Long altura;
	private Long qtdmotor;
	private Long pesovazio;
	private Long pesodecolagem;
	private String classe;
	private String paisorigem;
	private String modelo;
	private Long Velomaxima;

	private Long guidFabricante;

	@OneToMany(mappedBy = "guidAeronave")
	@Fetch(FetchMode.SUBSELECT)
	private List<Assento> assentos;

	public Long getGuidFabricante() {
		return guidFabricante;
	}

	public void setGuidFabricante(Long guidFabricante) {
		this.guidFabricante = guidFabricante;
	}

	public Long getGuidaeronave() {
		return guidaeronave;
	}

	public void setGuidaeronave(Long guidaeronave) {
		this.guidaeronave = guidaeronave;
	}

	public String getNomeaeronave() {
		return nomeaeronave;
	}

	public void setNomeaeronave(String nomeaeronave) {
		this.nomeaeronave = nomeaeronave;
	}

	public Long getComprimento() {
		return comprimento;
	}

	public void setComprimento(Long comprimento) {
		this.comprimento = comprimento;
	}

	public Long getEnvergadura() {
		return envergadura;
	}

	public void setEnvergadura(Long envergadura) {
		this.envergadura = envergadura;
	}

	public Long getAltura() {
		return altura;
	}

	public void setAltura(Long altura) {
		this.altura = altura;
	}

	public Long getQtdmotor() {
		return qtdmotor;
	}

	public void setQtdmotor(Long qtdmotor) {
		this.qtdmotor = qtdmotor;
	}

	public Long getPesovazio() {
		return pesovazio;
	}

	public void setPesovazio(Long pesovazio) {
		this.pesovazio = pesovazio;
	}

	public Long getPesodecolagem() {
		return pesodecolagem;
	}

	public void setPesodecolagem(Long pesodecolagem) {
		this.pesodecolagem = pesodecolagem;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getPaisorigem() {
		return paisorigem;
	}

	public void setPaisorigem(String paisorigem) {
		this.paisorigem = paisorigem;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Long getVelomaxima() {
		return Velomaxima;
	}

	public void setVelomaxima(Long velomaxima) {
		Velomaxima = velomaxima;
	}

	public List<Assento> getAssentos() {
		return assentos;
	}

	public void setAssentos(List<Assento> assentos) {
		this.assentos = assentos;
	}

}
