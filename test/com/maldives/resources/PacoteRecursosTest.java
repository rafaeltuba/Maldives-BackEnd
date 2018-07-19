package com.maldives.resources;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PacoteRecursosTest extends com.maldives.service.Test {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before 
	public void initialize() {
		Locale.setDefault(new Locale(PacoteRecurso.LOCALE_PORTUGUES_BRASIL));
    }
	
	@Test
	public void a_localeDefaultDaJVMEhIgualDoSelecionadoPeloUsuarioTest() {
		Locale.setDefault(new Locale(PacoteRecurso.LOCALE_PORTUGUES_BRASIL));
		assertEquals(PacoteRecurso.getPacoteRecurso().isLocaleDiferente(), false);
	}
	
	@Test
	public void b_localeDefaultDaJVMEhDiferenteDoSelecionadoPeloUsuarioTest() {
		Locale.setDefault(Locale.CANADA);
		assertEquals(PacoteRecurso.getPacoteRecurso().isLocaleDiferente(), true);
	}
	
	@Test
	public void c_carregarPacoteRecursos_pt_BR_comSucessoTest() {
		Locale.setDefault(new Locale(PacoteRecurso.LOCALE_PORTUGUES_BRASIL));
		assertEquals(PacoteRecurso.getPacoteRecurso().getLabel("empresa.nome.empresa.embranco"), "Nome da empresa está em branco.");
	}
	
	@Test
	public void d_localeNaoMapeadoNoSistemaTest() {
		Locale.setDefault(Locale.CANADA);
		exception.expect(InternalError.class);
	    exception.expectMessage("Resource Bundle não foi identificado para lingua '" + Locale.getDefault().getLanguage()+"_"+Locale.getDefault().getCountry()+"'.");
	    PacoteRecurso.getPacoteRecurso().getLabel("empresa.nome.empresa.embranco");
	}
	
	

}
