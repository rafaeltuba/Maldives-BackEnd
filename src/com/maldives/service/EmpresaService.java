package com.maldives.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.maldives.model.Empresa;
import com.maldives.repository.EmpresaRepository;
import com.maldives.resources.PacoteRecurso;

public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public boolean registrarNovaEmpresa(Empresa empresa) {
		
		if (empresa.getNmEmpresa() == null || "".equals(empresa.getNmEmpresa())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("empresa.nome.empresa.embranco"));
		}
		
		if (empresa.getDeEmail() == null || "".equals(empresa.getDeEmail())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("empresa.email.embranco"));
		}
		
		if (empresa.getCdRamoAtividade() == null) {
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("empresa.ramo.atividade.embranco"));
		}
		return this.save(empresa);
	}
	
	public Empresa findByEmail(final String email) {
		return empresaRepository.findByEmail(email);
	}
	
	public void deleteAll() {
		try {
			empresaRepository.deleteAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean save(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	public void setEmpresaRepository(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}
	
}
