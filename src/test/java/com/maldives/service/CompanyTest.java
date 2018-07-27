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

import com.maldives.domain.Company;
import com.maldives.repository.CompanyRepository;
import com.maldives.resources.PacoteRecurso;

@RunWith(SpringJUnit4ClassRunner.class)
public class CompanyTest extends com.maldives.service.Test {
	
	@InjectMocks
    private CompanyService companyService;
	
    @Mock
    private CompanyRepository companyRepository;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void saveCompanyWithSucess() {
		
		Company company = new Company();
		company.setCompanyName("Resultados Virtuais");
		company.setLineBusiness(1);
		company.setEmail("contato@resultadosvirtuais.com.br");
		Mockito.when(companyRepository.insert(company)).thenReturn(true);
		assertEquals(companyService.saveNewCompany(company), true);
		
	}
	@Test
	public void saveCompanyWithoutCompanyNameTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("empresa.nome.empresa.embranco"));
		
		Company company = new Company();
		company.setCompanyName(null);
		company.setLineBusiness(1);
		company.setEmail("contato@resultadosvirtuais.com.br");
		
		Mockito.when(companyRepository.insert(company)).thenReturn(false);
		companyService.saveNewCompany(company);
		
	}
	
	@Test
	public void saveCompanyWithoutLineBusinessTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("empresa.ramo.atividade.embranco"));
		
		Company company = new Company();
		company.setCompanyName("Resultados Virtuais");
		company.setLineBusiness(null);
		company.setEmail("contato@resultadosvirtuais.com.br");
		
		Mockito.when(companyRepository.insert(company)).thenReturn(false);
		companyService.saveNewCompany(company);
		
	}
	
	@Test
	public void saveCompanyWithoutEmailTest() {
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("empresa.email.embranco"));
		
		Company company = new Company();
		company.setCompanyName("Resultados Virtuais");
		company.setLineBusiness(1);
		company.setEmail(null);
		
		Mockito.when(companyRepository.insert(company)).thenReturn(false);
		companyService.saveNewCompany(company);
		
	}
	
}
