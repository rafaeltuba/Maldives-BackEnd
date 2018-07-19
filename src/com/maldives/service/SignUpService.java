package com.maldives.service;

import com.maldives.model.Empresa;
import com.maldives.resources.PacoteRecurso;

public class SignUpService {

	public void inscreverEmpresa(Empresa empresa, Boolean flAceiteTermos) {
		if (flAceiteTermos == null || flAceiteTermos == false) {
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("signup.termo.nao.marcado"));
		}
		new EmpresaService().registrarNovaEmpresa(empresa);
		new UsuarioService().saveUsuarioEmpresa(empresa.getDeEmail(), empresa.getDeSenha());
	}

}
