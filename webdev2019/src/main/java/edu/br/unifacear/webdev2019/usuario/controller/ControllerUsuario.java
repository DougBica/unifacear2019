package edu.br.unifacear.webdev2019.usuario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.usuario.entity.Usuario;
import edu.br.unifacear.webdev2019.usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class ControllerUsuario {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public void salvar(@RequestBody Usuario usuario) {
		usuarioService.salvar(usuario);
	}
	
	@GetMapping
	public List<Usuario> listar() {
		return usuarioService.listar();
	}
	
	@GetMapping("/{guidPassagem}")
	public Optional<Usuario> BuscarPorID( Long guidPassagem) {
		return usuarioService.BuscarPorID(guidPassagem);
	}
	
}
