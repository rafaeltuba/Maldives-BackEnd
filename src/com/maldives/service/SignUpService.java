package com.maldives.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.maldives.model.Empresa;
import com.maldives.model.Usuario;
import com.maldives.resources.PacoteRecurso;

public class SignUpService {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public boolean registrarEmpresa(Empresa empresa, Usuario usuario, Boolean flAceiteTermos) {
		
		if (flAceiteTermos == null || flAceiteTermos == false) {
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("signup.termo.nao.marcado"));
		}
		boolean empresaSalva = empresaService.registrarNovaEmpresa(empresa);
		
		empresa = empresaService.findByEmail(empresa.getDeEmail());
		
		usuario.setIdEmpresa(empresa.getIdEmpresa());
		
		boolean usuarioSalvo = usuarioService.insert(usuario);
		
		return usuarioSalvo && empresaSalva;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public void setEmpresaService(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}
	
}
