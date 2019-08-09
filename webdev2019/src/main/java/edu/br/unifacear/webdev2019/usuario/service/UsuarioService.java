package edu.br.unifacear.webdev2019.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.usuario.entity.Usuario;
import edu.br.unifacear.webdev2019.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void salvar(Usuario usuario) {
		//if (usuario.getIdade() == null
		//		&& usuario.getIdade() < 18) {
			//lançar uma excecao 
		//}		
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
}
