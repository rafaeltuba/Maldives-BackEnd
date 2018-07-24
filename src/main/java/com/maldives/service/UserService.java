package com.maldives.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maldives.domain.Company;
import com.maldives.domain.User;
import com.maldives.repository.UserRepository;
import com.maldives.resources.PacoteRecurso;

@Service
public class UserService {
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean signUpCompany(Company company, User user, Boolean acceptedTermsConditions) {
		
		if (acceptedTermsConditions == null || acceptedTermsConditions == false) {
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("signup.termo.nao.marcado"));
		}
		user.setUserType(User.USERTYPE_COMPANY);
		boolean savedUser = this.insert(user);
		user = this.findByEmail(company.getEmail());
		company.setUserId(user.getUserId());
		boolean empresaSalva = companyService.saveNewCompany(company);
		
		return savedUser && empresaSalva;
	}

	public void setEmpresaService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public boolean insert(User user) {
		
		if (user.getPassword() == null || "".equals(user.getPassword())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("user.password.empty"));
		}
		
		if (user.getEmailId() == null || "".equals(user.getEmailId())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("usuario.email.embranco"));
		}
		
		if (user.getUserType() == null) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("usuario.tipo.usuario.embranco"));
		}
		
		return userRepository.insert(user);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
