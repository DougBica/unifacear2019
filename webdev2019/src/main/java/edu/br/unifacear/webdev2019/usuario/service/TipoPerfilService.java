package edu.br.unifacear.webdev2019.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.br.unifacear.webdev2019.common.exception.BusinessException;
import edu.br.unifacear.webdev2019.common.exception.BusinessExceptionCode;
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

	public TipoPerfil BuscarId(final Long guidTipoPerfil) {
		TipoPerfil tipoperfil = Optional.ofNullable(tipoPerfilRepository.findById(guidTipoPerfil).orElse(null))
				.orElseThrow(() -> new BusinessException(BusinessExceptionCode.ERR001));
		return tipoperfil;
	}

}


