package edu.br.unifacear.webdev2019.passagem.dto;

import java.util.List;

import edu.br.unifacear.webdev2019.passagem.entity.Passagem;
import edu.br.unifacear.webdev2019.usuario.entity.Usuario;

public class PassagensUsuario {
	
	private List<Passagem> listaPassagens;
	private Usuario user;
	
	
	
	public List<Passagem> getListaPassagens() {
		return listaPassagens;
	}
	public void setListaPassagens(List<Passagem> listaPassagens) {
		this.listaPassagens = listaPassagens;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	
	
	
	
	
	

}
