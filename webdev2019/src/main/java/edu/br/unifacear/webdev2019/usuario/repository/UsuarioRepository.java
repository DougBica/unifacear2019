package edu.br.unifacear.webdev2019.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.br.unifacear.webdev2019.usuario.entity.Usuario;

public interface UsuarioRepository 
	extends JpaRepository<Usuario, Long>{
	
	public Usuario findByEmail(String email);
	
}
