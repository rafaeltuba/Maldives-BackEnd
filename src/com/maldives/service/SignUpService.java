package com.maldives.service;

import com.maldives.model.Empresa;

public class SignUpService {

	public void inscreverEmpresa(Empresa empresa, Boolean flAceiteTermos) {
		if (flAceiteTermos == null || flAceiteTermos == false) {
			throw new IllegalArgumentException("O termo n�o foi aceito pelo usu�rio");
		}
		new EmpresaService().registrarNovaEmpresa(empresa);
		new UsuarioService().saveUsuarioEmpresa(empresa.getDeEmail(), empresa.getDeSenha());
	}

}
