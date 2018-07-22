package com.maldives.repository;

import com.maldives.model.Empresa;

public interface EmpresaRepository {
	
	public boolean insert(Empresa empresa);
	 
	public Empresa findByEmail(final String email);
	
}
