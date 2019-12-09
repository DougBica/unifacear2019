package edu.br.unifacear.webdev2019.usuario.service;

import java.util.ArrayList;
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
import edu.br.unifacear.webdev2019.usuario.entity.Permissao;
import edu.br.unifacear.webdev2019.usuario.entity.TipoPerfil;
import edu.br.unifacear.webdev2019.usuario.entity.TipoUsuario;
import edu.br.unifacear.webdev2019.usuario.entity.Usuario;
import edu.br.unifacear.webdev2019.usuario.entity.email;
import edu.br.unifacear.webdev2019.usuario.repository.TipoPerfilRepository;
import edu.br.unifacear.webdev2019.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	private TipoPerfilRepository tipoperfilrepository;
	private TipoPerfilService tipoperfilsevice;
	
	@Transactional
	public void salvar(Usuario usuario) {
		String senha;
	    email emailU = new email("smtp.gmail.com","465");
		TipoPerfil perfil = new TipoPerfil();
		List<Permissao> permissoes = new ArrayList<Permissao>();
		if(usuario.getGuidUsuario() == null) {
			permissoes.add(Permissao.GERENCIAR_USUARIO);
			perfil.setGuidTipoPerfil((long) 1);
			perfil.setDescricao("ADMIN");
			perfil.setPermissoes(permissoes);
			senha = gerarSenha();
        	System.out.println(senha);
        	usuario.setPerfil(perfil);
    		usuario.setSenha(senha);
    		usuario.setTipoDeUsuarios(TipoUsuario.ADMIN);
    		emailU.sendMail("facearairlines@gmail.com", usuario.getEmail(), "Senha Facear Airlines", "Sua senha para acesso é:"+usuario.getSenha() );
        }
		usuarioRepository.save(usuario);
	}

	@Transactional
	public void salvarCliente(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	private static String gerarSenha(){
		int qtdeMaximaCaracteres = 8;
	    String[] caracteres = { "0", "1", "b", "2", "4", "5", "6", "7", "8",
	                "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
	                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
	                "x", "y", "z"};
	    
		StringBuilder senha = new StringBuilder();

        for (int i = 0; i < qtdeMaximaCaracteres; i++) {
            int posicao = (int) (Math.random() * caracteres.length);
            senha.append(caracteres[posicao]);
        }
        return senha.toString();
        
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
	
	public Optional<Usuario> findByMyId(Long id) {
		return usuarioRepository.findById(id);
	}
}