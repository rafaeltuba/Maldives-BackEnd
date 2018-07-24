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
import com.maldives.repository.UserRepository;
import com.maldives.resources.PacoteRecurso;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest extends com.maldives.service.Test {
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private CompanyService companyService;
	
	@InjectMocks
	private UserService userService;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	
	@Test
	public void signUpCompanyWithSucessTest() {
		
		Boolean acceptedTermsConditions = true;
		String password = "123";
		
		Company company = new Company();
		company.setCompanyName("Resultados Virtuais");
		company.setLineBusiness(1);
		company.setEmail("contato@resultadosvirtuais.com.br");
		
		User user = new User();
		user.setEmailId(company.getEmail());
		user.setPassword(password);
		user.setUserType(User.USERTYPE_COMPANY);
		
		User userReturn = new User();
		userReturn.setUserId(1);
		userReturn.setEmailId("contato@resultadosvirtuais.com.br");
		userReturn.setPassword(password);
		userReturn.setUserType(User.USERTYPE_COMPANY);
		
		Mockito.when(companyService.saveNewCompany(company)).thenReturn(true);
		Mockito.when(userRepository.insert(user)).thenReturn(true);
		Mockito.when(userRepository.findByEmail(company.getEmail())).thenReturn(userReturn);
		
		assertEquals(userService.signUpCompany(company, user, acceptedTermsConditions), true);
	}
	
	@Test
	public void signUpCompanyWithoutAcceptedTermsConditionsTest() {
		
		Boolean acceptedTermsConditions = true;
		String password = "123";
		
		Company company = new Company();
		company.setCompanyName("Resultados Virtuais");
		company.setLineBusiness(1);
		company.setEmail("contato@resultadosvirtuais.com.br");
		
		User user = new User();
		user.setEmailId(company.getEmail());
		user.setPassword(password);
		user.setUserType(User.USERTYPE_COMPANY);
		
		User userReturn = new User();
		userReturn.setUserId(1);
		userReturn.setEmailId("contato@resultadosvirtuais.com.br");
		userReturn.setPassword(password);
		userReturn.setUserType(User.USERTYPE_COMPANY);
		
		Mockito.when(companyService.saveNewCompany(company)).thenReturn(true);
		Mockito.when(userRepository.insert(user)).thenReturn(true);
		Mockito.when(userRepository.findByEmail(company.getEmail())).thenReturn(userReturn);
		
		assertEquals(userService.signUpCompany(company, user, acceptedTermsConditions), true);
	}
	
	@Test
	public void saveUserWithSucessTest() {
		
		String password = "123";
		
		User user = new User();
		user.setEmailId("rafael@resultadosvirtuais.com");
		user.setPassword(password);
		user.setUserType(User.USERTYPE_COMPANY);
		
		Mockito.when(userRepository.insert(user)).thenReturn(true);
		
		assertEquals(userService.insert(user), true);
	}
	
	@Test
	public void saveCompanyUserWithoutEmailIdTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("usuario.email.embranco"));
	    
	    String password = "123";
	    
	    User user = new User();
		user.setPassword(password);
		
		Mockito.when(userRepository.insert(user)).thenReturn(false);
		
		userService.insert(user);
	}
	
	@Test
	public void saveCompanyUserWithoutPasswordTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("user.password.empty"));
	    
	    User user = new User();
		user.setEmailId("rafael@resultadosvirtuais.com");
		user.setUserType(User.USERTYPE_COMPANY);
		
		Mockito.when(userRepository.insert(user)).thenReturn(false);
		
		userService.insert(user);
	}
	
	@Test
	public void saveCompanyUserWithoutUserTypeTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("usuario.tipo.usuario.embranco"));
	    
	    String password = "123";
	    
	    User user = new User();
		user.setEmailId("rafael@resultadosvirtuais.com");
		user.setPassword(password);
		
		Mockito.when(userRepository.insert(user)).thenReturn(false);
		
		userService.insert(user);
	}

}
