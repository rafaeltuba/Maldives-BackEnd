package com.maldives.service;

import com.maldives.model.Empresa;

public class EmpresaService {

	public void registrarNovaEmpresa(Empresa empresa) {
		
		if (empresa.getNmEmpresa() == null || "".equals(empresa.getNmEmpresa())) { 
			throw new IllegalArgumentException("Nome da empresa está em branco.");
		}
		
		if (empresa.getDeEmail() == null || "".equals(empresa.getDeEmail())) { 
			throw new IllegalArgumentException("E-mail da empresa deve ser preenchido");
		}
		
		if (empresa.getDeSenha() == null || "".equals(empresa.getDeSenha())) { 
			throw new IllegalArgumentException("Senha da empresa deve ser preenchido");
		}
		
		if (empresa.getCdRamoAtividade() == null) {
			throw new IllegalArgumentException("Ramo de atividade da empresa deve ser preenchido");
		}
		
		this.save(empresa);
	}

	private void save(Empresa empresa) {
		// TODO Auto-generated method stub
	}


}
