package com.maldives.service;

import com.maldives.model.Usuario;

public class UsuarioService {

	// � melhor passar o usu�rio como par�metro ou como est� agora?
	public void saveUsuarioEmpresa(String deEmailId, String deSenha) {
		
		if (deEmailId == null || "".equals(deEmailId)) { 
			throw new IllegalArgumentException("E-mail do usu�rio deve ser preenchido");
		}
		
		if (deSenha == null || "".equals(deSenha)) { 
			throw new IllegalArgumentException("Senha do usu�rio deve ser preenchida");
		}
		
		Usuario usuario = new Usuario();
		usuario.setDeEmailId(deEmailId);
		usuario.setDeSenha(deSenha);
		usuario.setTpUsuario(Usuario.TPUSUARIO_EMPRESA);
		
		this.save(usuario);		
	}

	private void save(Usuario usuario) {
		
		if (usuario.getDeSenha() == null || "".equals(usuario.getDeSenha())) { 
			throw new IllegalArgumentException("E-mail do usu�rio deve ser preenchido");
		}
		
		if (usuario.getDeEmailId() == null || "".equals(usuario.getDeEmailId())) { 
			throw new IllegalArgumentException("Senha do usu�rio deve ser preenchida");
		}
	}
	
	
	

}
