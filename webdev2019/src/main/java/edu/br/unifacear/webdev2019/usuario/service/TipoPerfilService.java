package edu.br.unifacear.webdev2019.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.br.unifacear.webdev2019.usuario.entity.TipoPerfil;
import edu.br.unifacear.webdev2019.usuario.entity.Usuario;
import edu.br.unifacear.webdev2019.usuario.repository.TipoPerfilRepository;
import edu.br.unifacear.webdev2019.usuario.repository.UsuarioRepository;

@Service
public class TipoPerfilService {

	@Autowired
	private TipoPerfilRepository tipoPerfilRepository;

	@Transactional
	public void salvar(TipoPerfil tipoPerfil) {
		tipoPerfilRepository.save(tipoPerfil);
	}

	public void excluir(TipoPerfil tipoPerfil) {
		tipoPerfilRepository.delete(tipoPerfil);
	}

	public List<TipoPerfil> listar() {
		return tipoPerfilRepository.findAll();
	}

	public List<TipoPerfil> BuscarId(Iterable<Long> guidTipoPerfil) {
		return tipoPerfilRepository.findAllById(guidTipoPerfil);
	}
	
}


