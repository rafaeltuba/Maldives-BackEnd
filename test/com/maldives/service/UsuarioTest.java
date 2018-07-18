package com.maldives.service;

import org.junit.Test;

public class UsuarioTest {
	
	@Test
	public void salvarUsuarioComSucesso() {
		UsuarioService usuarioService = new UsuarioService();
		usuarioService.saveUsuarioEmpresa("contato@resultadosvirtuais", "123456");
	}

}
