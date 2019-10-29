package edu.br.unifacear.webdev2019.autenticacao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import edu.br.unifacear.webdev2019.autenticacao.model.CustomUser;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDetailServiceImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {
		return getCustomUser(userName);
	}

	private CustomUser getCustomUser(String userName) {

		// CustomUser customUser = jdbcTemplate.
		// queryForObject("select guid_usuario, email as login, senha from usuario where
		// email=?",new
		// Object[]{userName},new UserRowMapper());
		// if(customUser != null){
		// customUser = new CustomUser(customUser.getUsername(),new
		// BCryptPasswordEncoder().encode(customUser.getPassword()),customUser.isEnabled(),customUser.isAccountNonExpired(),customUser.isCredentialsNonExpired(),
		// customUser.isAccountNonLocked(),getUserRoles(customUser.getId()));
		// }

		ArrayList<GrantedAuthority> permissoes = new ArrayList<GrantedAuthority>();
		permissoes.add(new SimpleGrantedAuthority("GERENCIAR_VOO"));
		CustomUser customUser = new CustomUser("admin@scp.com", new BCryptPasswordEncoder().encode("123"), true, true,
				true, true, permissoes);

		return customUser;
	}

	private class UserRowMapper implements RowMapper<CustomUser> {
		@Override
		public CustomUser mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new CustomUser(rs.getString("login"), rs.getString("senha"), true, true, true, true,
					Collections.emptyList());

		}
	}

	private List<GrantedAuthority> getUserRoles(Long ID) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		// List<String> roles = jdbcTemplate.queryForList(
		// "select distinct pp.PERMISSAO from PERFIL_PERMISSAO pp left join
		// USUARIO_PERFIL up on up.PERFIL_ID = pp.ID where up.USUARIO_ID=?",
		// new Object[] { ID }, String.class);

		// if (roles != null) {
		// roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
		// }

		return authorities;

	}
}