package com.maldives.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.maldives.model.Empresa;
import com.maldives.resources.PacoteRecurso;

public class EmpresaTest extends com.maldives.service.Test {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void saveRegistrarEmpresaComSucessoTest() {
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa("Resultados Virtuais");
		empresa.setCdRamoAtividade(1);
		empresa.setDeEmail("contato@resultadosvirtuais.com.br");
		empresa.setDeSenha("123456");
		
		EmpresaService empresaService = new EmpresaService();
		empresaService.registrarNovaEmpresa(empresa);
		
	}
	
	@Test
	public void saveRegistrarEmpresaSemNomePreenchidoTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("empresa.nome.empresa.embranco"));
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa(null);
		empresa.setCdRamoAtividade(1);
		empresa.setDeEmail("contato@resultadosvirtuais.com.br");
		empresa.setDeSenha("123456");
		
		EmpresaService empresaService = new EmpresaService();
		empresaService.registrarNovaEmpresa(empresa);
		
	}
	
	@Test
	public void saveRegistrarEmpresaSemRamoAtividadePreenchidoTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("empresa.ramo.atividade.embranco"));
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa("Resultados Virtuais");
		empresa.setCdRamoAtividade(null);
		empresa.setDeEmail("contato@resultadosvirtuais.com.br");
		empresa.setDeSenha("123456");
		
		EmpresaService empresaService = new EmpresaService();
		empresaService.registrarNovaEmpresa(empresa);
		
	}
	
	@Test
	public void saveRegistrarEmpresaSemEmailPreenchido() {
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("empresa.email.embranco"));
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa("Resultados Virtuais");
		empresa.setCdRamoAtividade(1);
		empresa.setDeEmail(null);
		empresa.setDeSenha("123456");
		
		EmpresaService empresaService = new EmpresaService();
		empresaService.registrarNovaEmpresa(empresa);
		
	}
	
	@Test
	public void saveRegistrarEmpresaSemSenhaPreenchida() {
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("empresa.senha.embranco"));
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa("Resultados Virtuais");
		empresa.setCdRamoAtividade(1);
		empresa.setDeEmail("contato@resultadosvirtuais.com.br");
		empresa.setDeSenha(null);
		
		EmpresaService empresaService = new EmpresaService();
		empresaService.registrarNovaEmpresa(empresa);
		
	}
	
}
