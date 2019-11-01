package edu.br.unifacear.webdev2019.usuario.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.br.unifacear.webdev2019.usuario.entity.TipoUsuario;
import edu.br.unifacear.webdev2019.usuario.entity.Usuario;
import edu.br.unifacear.webdev2019.usuario.service.UsuarioService;


@RestController
@RequestMapping("/scp/public/register")
public class ControllerCliente {
		@Autowired
		private UsuarioService usuarioService;


		@PostMapping
		public void salvar(@RequestBody Usuario usuario) {
			usuario.setTipoDeUsuarios(TipoUsuario.CLIENTE);
			usuarioService.salvar(usuario);
		}

		@GetMapping
		public List<Usuario> listar() {
			return usuarioService.listar();
		}


		@DeleteMapping
		public void deleteUsuario(@RequestBody Usuario usuario) {
			usuarioService.excluir(usuario);
		}
	
}
