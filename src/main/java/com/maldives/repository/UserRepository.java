package com.maldives.repository;

import com.maldives.domain.User;

public interface UserRepository {
	
	public boolean insert(User user);
	
	public User findByEmail(final String email);
	
}
