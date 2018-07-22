package com.maldives.service;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.maldives.model.Empresa;
import com.maldives.repository.EmpresaRepository;
import com.maldives.resources.PacoteRecurso;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmpresaTest extends com.maldives.service.Test {
	
	@InjectMocks
    private EmpresaService empresaService;
	
    @Mock
    private EmpresaRepository empresaRepository;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void registrarEmpresaComSucessoTest() {
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa("Resultados Virtuais");
		empresa.setCdRamoAtividade(1);
		empresa.setDeEmail("contato@resultadosvirtuais.com.br");
		Mockito.when(empresaRepository.save(empresa)).thenReturn(true);
		assertEquals(empresaService.registrarNovaEmpresa(empresa), true);
		
	}
	@Test
	public void registrarEmpresaSemNomePreenchidoTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("empresa.nome.empresa.embranco"));
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa(null);
		empresa.setCdRamoAtividade(1);
		empresa.setDeEmail("contato@resultadosvirtuais.com.br");
		
		Mockito.when(empresaRepository.save(empresa)).thenReturn(false);
		empresaService.registrarNovaEmpresa(empresa);
		
	}
	
	@Test
	public void registrarEmpresaSemRamoAtividadePreenchidoTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("empresa.ramo.atividade.embranco"));
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa("Resultados Virtuais");
		empresa.setCdRamoAtividade(null);
		empresa.setDeEmail("contato@resultadosvirtuais.com.br");
		
		Mockito.when(empresaRepository.save(empresa)).thenReturn(false);
		empresaService.registrarNovaEmpresa(empresa);
		
	}
	
	@Test
	public void registrarEmpresaSemEmailPreenchido() {
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("empresa.email.embranco"));
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa("Resultados Virtuais");
		empresa.setCdRamoAtividade(1);
		empresa.setDeEmail(null);
		
		Mockito.when(empresaRepository.save(empresa)).thenReturn(false);
		empresaService.registrarNovaEmpresa(empresa);
		
	}
	
}
