package com.maldives.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.maldives.domain.User;
import com.maldives.repository.UsuarioRepository;
import com.maldives.resources.PacoteRecurso;

public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public boolean insert(User user) {
		
		if (user.getPassword() == null || "".equals(user.getPassword())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("usuario.senha.embranco"));
		}
		
		if (user.getEmailId() == null || "".equals(user.getEmailId())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("usuario.email.embranco"));
		}
		
		if (user.getUserType() == null) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("usuario.tipo.usuario.embranco"));
		}
		
		return usuarioRepository.insert(user);
	}
	
	public User findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

}
