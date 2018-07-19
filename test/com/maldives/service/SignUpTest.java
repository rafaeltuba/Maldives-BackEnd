package com.maldives.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.maldives.model.Empresa;
import com.maldives.resources.PacoteRecurso;

public class SignUpTest extends com.maldives.service.Test {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

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
	
	@Test
	public void inscreverEmpresaSemAceiteDosTermosTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("signup.termo.nao.marcado"));
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa("Resultados Virtuais");
		empresa.setCdRamoAtividade(1);
		empresa.setDeEmail("contato@resultadosvirtuais.com.br");
		empresa.setDeSenha("123456");
		
		Boolean flAceiteTermos = false;
		
		new SignUpService().inscreverEmpresa(empresa, flAceiteTermos);
	}
	
}
