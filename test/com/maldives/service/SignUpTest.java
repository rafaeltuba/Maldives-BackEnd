package com.maldives.service;

import org.junit.Test;

import com.maldives.model.Empresa;

public class SignUpTest {

	@Test
	public void inscreverEmpresaComSucesso() {
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa("Resultados Virtuais");
		empresa.setCdRamoAtividade(1);
		empresa.setDeEmail("contato@resultadosvirtuais.com.br");
		empresa.setDeSenha("123456");
		
		Boolean flAceiteTermos = true;
		
		new SignUpService().inscreverEmpresa(empresa, flAceiteTermos);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void inscreverEmpresaSemAceitoDosTermos() {
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa("Resultados Virtuais");
		empresa.setCdRamoAtividade(1);
		empresa.setDeEmail("contato@resultadosvirtuais.com.br");
		empresa.setDeSenha("123456");
		
		Boolean flAceiteTermos = false;
		
		new SignUpService().inscreverEmpresa(empresa, flAceiteTermos);
	}
	
}
