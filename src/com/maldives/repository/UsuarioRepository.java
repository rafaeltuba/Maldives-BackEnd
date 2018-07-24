package com.maldives.repository;

import com.maldives.domain.User;

public interface UsuarioRepository {
	
	public boolean insert(User user);
	
	public User findByEmail(final String email);
	
}
