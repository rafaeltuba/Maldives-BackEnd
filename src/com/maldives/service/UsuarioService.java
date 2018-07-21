package com.maldives.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.maldives.model.Usuario;
import com.maldives.repository.UsuarioDB;
import com.maldives.resources.PacoteRecurso;


public class UsuarioService {
	
	@Autowired
	private UsuarioDB usuarioDB;
	
	public boolean save(Usuario usuario) {
		
		if (usuario.getDeSenha() == null || "".equals(usuario.getDeSenha())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("usuario.senha.embranco"));
		}
		
		if (usuario.getDeEmailId() == null || "".equals(usuario.getDeEmailId())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("usuario.email.embranco"));
		}
		
		if (usuario.getIdEmpresa() == null) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("usuario.id.empresa.embranco"));
		}
		
		return usuarioDB.save(usuario);
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
