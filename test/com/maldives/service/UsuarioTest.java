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

import com.maldives.domain.User;
import com.maldives.repository.UsuarioRepository;
import com.maldives.resources.PacoteRecurso;

@RunWith(SpringJUnit4ClassRunner.class)
public class UsuarioTest extends com.maldives.service.Test {
	
	@Mock
	private UsuarioRepository usuarioRepository;
	
	@InjectMocks
	private UsuarioService usuarioService;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void registrarUsuarioEmpresaComSucessoTest() {
		
		String senha = "123";
		
		User user = new User();
		user.setEmailId("rafael@resultadosvirtuais.com");
		user.setPassword(senha);
		user.setUserType(User.USERTYPE_COMPANY);
		
		Mockito.when(usuarioRepository.insert(user)).thenReturn(true);
		
		assertEquals(usuarioService.insert(user), true);
	}
	
	@Test
	public void registrarUsuarioEmpresaSemEmailIdTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("usuario.email.embranco"));
	    
	    String senha = "123";
	    
	    User user = new User();
		user.setPassword(senha);
		
		Mockito.when(usuarioRepository.insert(user)).thenReturn(false);
		
		usuarioService.insert(user);
	}
	
	@Test
	public void registrarUsuarioEmpresaSemSenhaTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("usuario.senha.embranco"));
	    
	    User user = new User();
		user.setEmailId("rafael@resultadosvirtuais.com");
		user.setUserType(User.USERTYPE_COMPANY);
		
		Mockito.when(usuarioRepository.insert(user)).thenReturn(false);
		
		usuarioService.insert(user);
	}
	
	@Test
	public void registrarUsuarioEmpresaSemTipoDeUsuario() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("usuario.tipo.usuario.embranco"));
	    
	    String senha = "123";
	    
	    User user = new User();
		user.setEmailId("rafael@resultadosvirtuais.com");
		user.setPassword(senha);
		
		Mockito.when(usuarioRepository.insert(user)).thenReturn(false);
		
		usuarioService.insert(user);
	}

}
