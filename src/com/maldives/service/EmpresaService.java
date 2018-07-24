package com.maldives.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.maldives.domain.Company;
import com.maldives.repository.EmpresaRepository;
import com.maldives.resources.PacoteRecurso;

public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public boolean registrarNovaEmpresa(Company company) {
		
		if (company.getCompanyName() == null || "".equals(company.getCompanyName())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("empresa.nome.empresa.embranco"));
		}
		
		if (company.getEmail() == null || "".equals(company.getEmail())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("empresa.email.embranco"));
		}
		
		if (company.getLineBusiness() == null) {
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("empresa.ramo.atividade.embranco"));
		}
		return this.insert(company);
	}
	
	public Company findByEmail(final String email) {
		return empresaRepository.findByEmail(email);
	}
	
	private boolean insert(Company company) {
		return empresaRepository.insert(company);
	}

	public void setEmpresaRepository(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}
	
}
