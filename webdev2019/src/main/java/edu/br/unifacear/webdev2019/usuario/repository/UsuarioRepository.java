package edu.br.unifacear.webdev2019.usuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.br.unifacear.webdev2019.usuario.entity.Usuario;

public interface UsuarioRepository 
	extends JpaRepository<Usuario, Long>{
	
	public Usuario findByEmail(String email);
		
	@Query("select u from Usuario u where u.nome like %:nome% and u.email like %:email%")
	public List<Usuario> procurarPorNomeOuEmail(@Param("nome") String nome, 
			@Param("email") String email);

}
