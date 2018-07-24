package com.maldives.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.maldives.domain.Company;
import com.maldives.domain.User;
import com.maldives.resources.PacoteRecurso;

public class SignUpService {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public boolean registrarEmpresa(Company company, User user, Boolean flAceiteTermos) {
		
		if (flAceiteTermos == null || flAceiteTermos == false) {
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("signup.termo.nao.marcado"));
		}
		user.setUserType(User.USERTYPE_COMPANY);
		boolean usuarioSalvo = usuarioService.insert(user);
		user = usuarioService.findByEmail(company.getEmail());
		company.setUserId(user.getUserId());
		boolean empresaSalva = empresaService.registrarNovaEmpresa(company);
		
		return usuarioSalvo && empresaSalva;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public void setEmpresaService(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}
	
}
