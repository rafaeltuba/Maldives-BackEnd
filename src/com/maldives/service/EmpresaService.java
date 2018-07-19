package com.maldives.service;

import com.maldives.model.Empresa;
import com.maldives.resources.PacoteRecurso;

public class EmpresaService {

	public void registrarNovaEmpresa(Empresa empresa) {
		
		if (empresa.getNmEmpresa() == null || "".equals(empresa.getNmEmpresa())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("empresa.nome.empresa.embranco"));
		}
		
		if (empresa.getDeEmail() == null || "".equals(empresa.getDeEmail())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("empresa.email.embranco"));
		}
		
		if (empresa.getDeSenha() == null || "".equals(empresa.getDeSenha())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("empresa.senha.embranco"));
		}
		
		if (empresa.getCdRamoAtividade() == null) {
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("empresa.ramo.atividade.embranco"));
		}
		this.save(empresa);
	}

	private void save(Empresa empresa) {
		// TODO Auto-generated method stub
	}


}
