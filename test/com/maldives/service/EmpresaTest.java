package com.maldives.service;

import org.junit.Test;

import com.maldives.model.Empresa;

public class EmpresaTest {

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
	
	
}
