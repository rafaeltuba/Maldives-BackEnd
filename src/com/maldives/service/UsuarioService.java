package com.maldives.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.maldives.model.Usuario;
import com.maldives.repository.UsuarioRepository;
import com.maldives.resources.PacoteRecurso;

public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public boolean insert(Usuario usuario) {
		
		if (usuario.getDeSenha() == null || "".equals(usuario.getDeSenha())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("usuario.senha.embranco"));
		}
		
		if (usuario.getDeEmailId() == null || "".equals(usuario.getDeEmailId())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("usuario.email.embranco"));
		}
		
		if (usuario.getIdEmpresa() == null) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("usuario.id.empresa.embranco"));
		}
		
		return usuarioRepository.insert(usuario);
	}
	
	public Usuario findByEmail(String deEmail) {
		return usuarioRepository.findByEmail(deEmail);
	}
	
	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

}
