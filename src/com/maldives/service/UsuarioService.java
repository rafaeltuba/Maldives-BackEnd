package com.maldives.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.maldives.model.Empresa;
import com.maldives.model.Usuario;
import com.maldives.repository.UsuarioDB;

public class UsuarioService {
	
	@Autowired
	UsuarioDB usuarioDB;
	
	public UsuarioService() {
	}
	
	// � melhor passar o usu�rio como par�metro ou como est� agora?
	public void saveUsuario(Empresa empresa, String senha) {
		
		if (empresa.getDeEmail() == null || "".equals(empresa.getDeEmail())) { 
			throw new IllegalArgumentException("E-mail do usu�rio deve ser preenchido");
		}
		
		if (senha == null || "".equals(senha)) { 
			throw new IllegalArgumentException("Senha do usu�rio deve ser preenchida");
		}
		
		if (empresa.getIdEmpresa() == null) { 
			throw new IllegalArgumentException("C�digo identificador da empresa est� nulo.");
		}
		
		Usuario usuario = new Usuario();
		usuario.setDeEmailId(empresa.getDeEmail());
		usuario.setDeSenha(senha);
		usuario.setTpUsuario(Usuario.TPUSUARIO_EMPRESA);
		usuario.setIdEmpresa(empresa.getIdEmpresa());
		this.save(usuario);		
	}

	private void save(Usuario usuario) {
		if (usuario.getDeSenha() == null || "".equals(usuario.getDeSenha())) { 
			throw new IllegalArgumentException("E-mail do usu�rio deve ser preenchido");
		}
		
		if (usuario.getDeEmailId() == null || "".equals(usuario.getDeEmailId())) { 
			throw new IllegalArgumentException("Senha do usu�rio deve ser preenchida");
		}
		
		if (usuario.getIdEmpresa() == null) { 
			throw new IllegalArgumentException("C�digo identificador da empresa est� nulo.");
		}
		
		try {
			usuarioDB.save(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAll() {
		try {
			usuarioDB.deleteAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setUsuarioDB(UsuarioDB usuarioDB) {
		this.usuarioDB = usuarioDB;
	}

}
