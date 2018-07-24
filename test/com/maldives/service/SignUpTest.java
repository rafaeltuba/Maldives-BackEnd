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
import com.maldives.domain.User;
import com.maldives.resources.PacoteRecurso;

@RunWith(SpringJUnit4ClassRunner.class)
public class SignUpTest extends com.maldives.service.Test {
	
	@InjectMocks
	private SignUpService signUpService;
	
	@Mock
	private EmpresaService empresaService;
	
	@Mock 
	private UsuarioService usuarioService;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void inscreverEmpresaComSucesso() {
		
		Boolean flAceiteTermos = true;
		String senha = "123";
		
		Company company = new Company();
		company.setCompanyName("Resultados Virtuais");
		company.setLineBusiness(1);
		company.setEmail("contato@resultadosvirtuais.com.br");
		
		User user = new User();
		user.setEmailId(company.getEmail());
		user.setPassword(senha);
		
		User userReturn = new User();
		userReturn.setUserId(1);
		userReturn.setEmailId("contato@resultadosvirtuais.com.br");
		userReturn.setPassword(senha);
		userReturn.setUserType(User.USERTYPE_COMPANY);
		
		Mockito.when(empresaService.registrarNovaEmpresa(company)).thenReturn(true);
		Mockito.when(usuarioService.insert(user)).thenReturn(true);
		Mockito.when(usuarioService.findByEmail(company.getEmail())).thenReturn(userReturn);
		
		assertEquals(signUpService.registrarEmpresa(company, user, flAceiteTermos), true);
	}
	
	@Test
	public void inscreverEmpresaSemAceiteDosTermosTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("signup.termo.nao.marcado"));
		
	    Boolean flAceiteTermos = false;
		String senha = "123";
		
		Company company = new Company();
		company.setCompanyName("Resultados Virtuais");
		company.setLineBusiness(1);
		company.setEmail("contato@resultadosvirtuais.com.br");
		
		User user = new User();
		user.setEmailId(company.getEmail());
		user.setPassword(senha);
		
		Company empresaReturn = new Company();
		empresaReturn.setCompanyName("Resultados Virtuais");
		empresaReturn.setLineBusiness(1);
		empresaReturn.setEmail("contato@resultadosvirtuais.com.br");
		empresaReturn.setCompanyId(1);
		
		Mockito.when(empresaService.registrarNovaEmpresa(company)).thenReturn(true);
		Mockito.when(usuarioService.insert(user)).thenReturn(true);
		Mockito.when(empresaService.findByEmail(company.getEmail())).thenReturn(empresaReturn);
		
		signUpService.registrarEmpresa(company, user, flAceiteTermos);
	    
	}
	
}
