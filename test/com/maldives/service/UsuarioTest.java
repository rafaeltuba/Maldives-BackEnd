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

import com.maldives.model.Usuario;
import com.maldives.repository.UsuarioDB;
import com.maldives.resources.PacoteRecurso;

@RunWith(SpringJUnit4ClassRunner.class)
public class UsuarioTest extends com.maldives.service.Test {
	
	@Mock
	private UsuarioDB usuarioDB;
	
	@InjectMocks
	private UsuarioService usuarioService;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void registrarUsuarioEmpresaComSucessoTest() {
		
		String senha = "123";
		
		Usuario usuario = new Usuario();
		usuario.setDeEmailId("rafael@resultadosvirtuais.com");
		usuario.setDeSenha(senha);
		usuario.setIdEmpresa(1);
		
		Mockito.when(usuarioDB.save(usuario)).thenReturn(true);
		
		assertEquals(usuarioService.save(usuario), true);
	}
	
	@Test
	public void registrarUsuarioEmpresaSemEmailIdTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("usuario.email.embranco"));
	    
	    String senha = "123";
	    
	    Usuario usuario = new Usuario();
		usuario.setDeSenha(senha);
		usuario.setIdEmpresa(1);
		
		Mockito.when(usuarioDB.save(usuario)).thenReturn(false);
		
		usuarioService.save(usuario);
	}
	
	@Test
	public void registrarUsuarioEmpresaSemSenhaTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("usuario.senha.embranco"));
	    
	    Usuario usuario = new Usuario();
		usuario.setDeEmailId("rafael@resultadosvirtuais.com");
		usuario.setTpUsuario(Usuario.TPUSUARIO_EMPRESA);
		usuario.setIdEmpresa(1);
		
		Mockito.when(usuarioDB.save(usuario)).thenReturn(false);
		
		usuarioService.save(usuario);
	}
	
	@Test
	public void registrarUsuarioEmpresaSemIdEmpresaTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("usuario.id.empresa.embranco"));
	    
	    String senha = "123";
	    
	    Usuario usuario = new Usuario();
		usuario.setDeEmailId("rafael@resultadosvirtuais.com");
		usuario.setDeSenha(senha);
		usuario.setTpUsuario(Usuario.TPUSUARIO_EMPRESA);
		
		Mockito.when(usuarioDB.save(usuario)).thenReturn(false);
		
		usuarioService.save(usuario);
	}

}
