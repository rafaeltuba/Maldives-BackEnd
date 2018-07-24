package com.maldives.repository;

import com.maldives.domain.Company;

public interface EmpresaRepository {
	
	public boolean insert(Company company);
	 
	public Company findByEmail(final String email);
	
}
