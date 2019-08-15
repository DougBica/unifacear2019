package edu.br.unifacear.webdev2019.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.br.unifacear.webdev2019.usuario.entity.Usuario;
import edu.br.unifacear.webdev2019.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public void salvar(Usuario usuario) {		
		usuarioRepository.save(usuario);
	}	
	
	public void excluir(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
}
