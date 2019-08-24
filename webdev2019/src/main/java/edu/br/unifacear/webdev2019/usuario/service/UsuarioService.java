package edu.br.unifacear.webdev2019.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;
import edu.br.unifacear.webdev2019.usuario.entity.Usuario;
import edu.br.unifacear.webdev2019.usuario.repository.TipoPerfilRepository;
import edu.br.unifacear.webdev2019.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	private TipoPerfilRepository tipoperfilrepository;
	
	@Transactional
	public void salvar(Usuario usuario) {
		if(usuario.getEmail().contentEquals(buscarPorEmail(usuario.getEmail()).getEmail())) {
			throw new BusinessException(BusinessExceptionCode.ERR004);
		}
		else {
			usuarioRepository.save(usuario);
		}
	}	
	
	public void excluir(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	public Usuario buscarPorId(final Long guidUsuario) {
	       Usuario usuario = Optional.ofNullable(usuarioRepository.findById(guidUsuario).
	               orElse(null))
	               .orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR001));
	       return usuario;
	   }
	public Usuario buscarPorEmail(final String email) {
		Usuario usuario = Optional.ofNullable(usuarioRepository.findByEmail(email))
	               .orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR003));
		return usuario;
	}
	public List<Usuario>Logar(final String email, final String senha) {
	       List<Usuario> usuario =  Optional.ofNullable(usuarioRepository.BuscarPorEmaileSenha(email,senha))
	               .orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR002));
	       return usuario;
	   }	
}
