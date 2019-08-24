package edu.br.unifacear.webdev2019.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;
import edu.br.unifacear.webdev2019.usuario.entity.Usuario;
import edu.br.unifacear.webdev2019.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario buscarPorId(final Long guidUsuario) {
        Usuario usuario = Optional.ofNullable(usuarioRepository.findById(guidUsuario).
        		orElse(null))
                .orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR001));
        return usuario;
    }
	
	public void salvar(Usuario usuario) {		
		//if (usuario.getPerfil() == null) {
		//	throw new BusinessException(BusinessExceptionCode.ERR001);
		//}
		
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	public void excluir(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	public Usuario buscarPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public List<Usuario> procurarPorNomeOuEmail(String nome, String email) {
		return usuarioRepository.procurarPorNomeOuEmail(nome, email);
	}
	
}
