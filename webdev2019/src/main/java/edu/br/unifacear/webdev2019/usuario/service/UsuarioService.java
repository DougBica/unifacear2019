package edu.br.unifacear.webdev2019.usuario.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.xml.crypto.Data;

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

		usuarioRepository.save(usuario);
	}

	public void excluir(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarPorId(final Long guidUsuario) {
		Usuario usuario = Optional.ofNullable(usuarioRepository.findById(guidUsuario).orElse(null))
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR001));		
		return usuario;
	}

	public Usuario buscarPorEmail(final String email) {
		Usuario u = new Usuario();
		u.setEmail("");
		Usuario usuario = Optional.ofNullable(usuarioRepository.findByEmail(email)).orElse(u);
		return usuario;
	}

	public Usuario buscarPorCpf(final String cpf) {
		Usuario u = new Usuario();
		u.setCpf("");
		Usuario usuario = Optional.ofNullable(usuarioRepository.findByCpf(cpf)).orElse(u);
		return usuario;
	}

	public List<Usuario> Logar(final String email, final String senha) {
		List<Usuario> usuario = Optional.ofNullable(usuarioRepository.BuscarPorEmaileSenha(email, senha))
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR002));
		return usuario;
	}
}