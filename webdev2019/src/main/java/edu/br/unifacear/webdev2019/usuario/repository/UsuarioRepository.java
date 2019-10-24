package edu.br.unifacear.webdev2019.usuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.br.unifacear.webdev2019.usuario.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByEmail(String email);

	public Usuario findByCpf(String cpf);

	@Query("select u from Usuario u where u.email = :email and u.senha = :senha")
	public List<Usuario> BuscarPorEmaileSenha(@Param("email") String email, @Param("senha") String senha);
}