package com.maldives.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.maldives.model.Empresa;
import com.maldives.resources.PacoteRecurso;

@Service
public class SignUpService {
	
	@Autowired
	EmpresaService empresaService;
	
	UsuarioService usuarioService;
	
	public SignUpService() {
		this.setUsuarioService(new UsuarioService());
	}

	public void inscreverEmpresa(Empresa empresa, Boolean flAceiteTermos, String senha) {
		if (flAceiteTermos == null || flAceiteTermos == false) {
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("signup.termo.nao.marcado"));
		}
		empresaService.registrarNovaEmpresa(empresa);
		empresa = empresaService.findByEmail(empresa.getDeEmail());
		usuarioService.saveUsuario(empresa, senha);
	}

	

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public void setEmpresaService(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}
	
}
