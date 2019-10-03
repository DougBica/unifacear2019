package edu.br.unifacear.webdev2019.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping("/Salvar")
	public void salvar(@RequestBody TipoPerfil tipoperfil) {
		tipoperfilService.salvar(tipoperfil);
	}
	
	@GetMapping("/Listar")
	public List<TipoPerfil> listar() {
		return tipoperfilService.listar();
	}
	
	@PostMapping("/Excluir")
	public void excluir(@RequestBody TipoPerfil tipoPerfil) {
		tipoperfilService.excluir(tipoPerfil);
	}
	
	@GetMapping("/BuscarId")
	public void BuscarId(Iterable<Long> guidTipoPerfil) {
		 tipoperfilService.BuscarId(guidTipoPerfil);
	}

}
