package edu.br.unifacear.webdev2019.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.usuario.entity.Usuario;
import edu.br.unifacear.webdev2019.usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/{guidUsuario}")
	public Usuario buscarPorId(@PathVariable(name = "guidUsuario") Long guidUsuario) {
		return usuarioService.buscarPorId(guidUsuario);
	}

	@GetMapping("/email/{email}")
	public Usuario buscarPorEmail(@PathVariable(name = "email") String email) {
		return usuarioService.buscarPorEmail(email);
	}

	@GetMapping
	public List<Usuario> listar() {
		return usuarioService.listar();
	}

	@PostMapping
	public void salvar(@RequestBody Usuario usuario) {
		usuarioService.salvar(usuario);
	}

	public void excluir(@RequestBody Usuario usuario) {
		usuarioService.excluir(usuario);
	}

}
