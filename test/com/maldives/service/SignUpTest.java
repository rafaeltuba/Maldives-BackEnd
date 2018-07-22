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
import com.maldives.model.Usuario;
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
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa("Resultados Virtuais");
		empresa.setCdRamoAtividade(1);
		empresa.setDeEmail("contato@resultadosvirtuais.com.br");
		
		Usuario usuario = new Usuario();
		usuario.setDeEmailId(empresa.getDeEmail());
		usuario.setDeSenha(senha);
		
		Empresa empresaReturn = new Empresa();
		empresaReturn.setNmEmpresa("Resultados Virtuais");
		empresaReturn.setCdRamoAtividade(1);
		empresaReturn.setDeEmail("contato@resultadosvirtuais.com.br");
		empresaReturn.setIdEmpresa(1);
		
		Mockito.when(empresaService.registrarNovaEmpresa(empresa)).thenReturn(true);
		Mockito.when(usuarioService.insert(usuario)).thenReturn(true);
		Mockito.when(empresaService.findByEmail(empresa.getDeEmail())).thenReturn(empresaReturn);
		
		assertEquals(signUpService.registrarEmpresa(empresa, usuario, flAceiteTermos), true);
	}
	
	@Test
	public void inscreverEmpresaSemAceiteDosTermosTest() {
		
		exception.expect(IllegalArgumentException.class);
	    exception.expectMessage(PacoteRecurso.getPacoteRecurso().getLabel("signup.termo.nao.marcado"));
		
	    Boolean flAceiteTermos = false;
		String senha = "123";
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa("Resultados Virtuais");
		empresa.setCdRamoAtividade(1);
		empresa.setDeEmail("contato@resultadosvirtuais.com.br");
		
		Usuario usuario = new Usuario();
		usuario.setDeEmailId(empresa.getDeEmail());
		usuario.setDeSenha(senha);
		
		Empresa empresaReturn = new Empresa();
		empresaReturn.setNmEmpresa("Resultados Virtuais");
		empresaReturn.setCdRamoAtividade(1);
		empresaReturn.setDeEmail("contato@resultadosvirtuais.com.br");
		empresaReturn.setIdEmpresa(1);
		
		Mockito.when(empresaService.registrarNovaEmpresa(empresa)).thenReturn(true);
		Mockito.when(usuarioService.insert(usuario)).thenReturn(true);
		Mockito.when(empresaService.findByEmail(empresa.getDeEmail())).thenReturn(empresaReturn);
		
		signUpService.registrarEmpresa(empresa, usuario, flAceiteTermos);
	    
	}
	
}
