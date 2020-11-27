package br.com.cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.cliente.model.Usuario;
import br.com.cliente.model.repository.UsuarioRepository;
import br.com.cliente.rest.exception.UsuarioCadastradoException;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository
					.findByUsername(username)
					.orElseThrow(()-> new UsernameNotFoundException("Usuario não encontrado."));
				
		return User
				.builder()
				.username(usuario.getUsername())
				.password(usuario.getPassword())
				.roles(usuario.getPerfil())
				.build();
	}
	
	public Usuario salvar(Usuario usuario) {
		if(repository.existsByUsername(usuario.getUsername())) {
			throw new UsuarioCadastradoException(usuario.getUsername());
		}
		return repository.save(usuario);
	}

}
