package com.maldives.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maldives.domain.Company;
import com.maldives.repository.CompanyRepository;
import com.maldives.util.PacoteRecurso;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	public boolean saveNewCompany(Company company) {
		
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
		return companyRepository.findByEmail(email);
	}
	
	private boolean insert(Company company) {
		return companyRepository.insert(company);
	}

	public void setCompanyRepository(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
}
