package edu.br.unifacear.webdev2019.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.usuario.entity.TipoPerfil;
import edu.br.unifacear.webdev2019.usuario.service.TipoPerfilService;

@RestController
@RequestMapping("/tipoperfil")
public class ControllerTipoPerfil {
	
	@Autowired
	private TipoPerfilService tipoperfilService;
	
	@PostMapping
	public void salvar(@RequestBody TipoPerfil tipoperfil) {
		tipoperfilService.salvar(tipoperfil);
	}
	
	@GetMapping
	public List<TipoPerfil> listar() {
		return tipoperfilService.listar();
	}
	
	@PostMapping
	public void excluir(@RequestBody TipoPerfil tipoPerfil) {
		tipoperfilService.excluir(tipoPerfil);
	}
	
	@GetMapping
	public void BuscarId(Iterable<Long> guidTipoPerfil) {
		 tipoperfilService.BuscarId(guidTipoPerfil);
	}

}
