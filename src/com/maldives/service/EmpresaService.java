package com.maldives.service;

import com.maldives.model.Empresa;

public class EmpresaService {

	public void registrarEmpresa(Empresa empresa) {
		
		if (empresa.getNmEmpresa() == null || "".equals(empresa.getNmEmpresa())) { 
			throw new IllegalArgumentException();
		}
	}


}
