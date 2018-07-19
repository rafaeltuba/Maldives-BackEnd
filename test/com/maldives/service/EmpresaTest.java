package com.maldives.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.maldives.model.Empresa;

public class EmpresaTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void saveRegistrarEmpresaComSucesso() {
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa("Resultados Virtuais");
		empresa.setCdRamoAtividade(1);
		empresa.setDeEmail("contato@resultadosvirtuais.com.br");
		empresa.setDeSenha("123456");
		
		EmpresaService empresaService = new EmpresaService();
		empresaService.registrarNovaEmpresa(empresa);
		
	}
	
	@Test
	public void saveRegistrarEmpresaSemNomePreenchido() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("Nome da empresa está em branco.");
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa(null);
		empresa.setCdRamoAtividade(1);
		empresa.setDeEmail("contato@resultadosvirtuais.com.br");
		empresa.setDeSenha("123456");
		
		EmpresaService empresaService = new EmpresaService();
		empresaService.registrarNovaEmpresa(empresa);
		
	}
	
	@Test
	public void saveRegistrarEmpresaSemRamoAtividadePreenchido() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage("Ramo de atividade da empresa deve ser preenchido");
		
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
	    exception.expectMessage("E-mail da empresa deve ser preenchido");
		
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
	    exception.expectMessage("Senha da empresa deve ser preenchido");
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa("Resultados Virtuais");
		empresa.setCdRamoAtividade(1);
		empresa.setDeEmail("contato@resultadosvirtuais.com.br");
		empresa.setDeSenha(null);
		
		EmpresaService empresaService = new EmpresaService();
		empresaService.registrarNovaEmpresa(empresa);
		
	}
	
}
