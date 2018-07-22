package com.maldives.repository;

import com.maldives.model.Usuario;

public interface UsuarioRepository {
	
	public boolean insert(Usuario usuario);
	
	public Usuario findByEmail(final String email);
	
}
