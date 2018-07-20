package com.maldives.service;

import org.junit.Test;

import com.maldives.model.Empresa;

public class UsuarioTest extends com.maldives.service.Test {
	
	@Test
	public void salvarUsuarioComSucesso() {
		
		UsuarioService usuarioService = new UsuarioService();
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa("Resultados Virtuais");
		empresa.setDeEmail("rafael@resultadosvirtuais.com");
		usuarioService.saveUsuario(empresa, "123");
	}

}
