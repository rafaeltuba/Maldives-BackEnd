package com.maldives.service;

import com.maldives.model.Usuario;

public class UsuarioService {

	// é melhor passar o usuário como parâmetro ou como está agora?
	public void saveUsuarioEmpresa(String deEmailId, String deSenha) {
		
		if (deEmailId == null || "".equals(deEmailId)) { 
			throw new IllegalArgumentException("E-mail do usuário deve ser preenchido");
		}
		
		if (deSenha == null || "".equals(deSenha)) { 
			throw new IllegalArgumentException("Senha do usuário deve ser preenchida");
		}
		
		Usuario usuario = new Usuario();
		usuario.setDeEmailId(deEmailId);
		usuario.setDeSenha(deSenha);
		usuario.setTpUsuario(Usuario.TPUSUARIO_EMPRESA);
		
		this.save(usuario);		
	}

	private void save(Usuario usuario) {
		
		if (usuario.getDeSenha() == null || "".equals(usuario.getDeSenha())) { 
			throw new IllegalArgumentException("E-mail do usuário deve ser preenchido");
		}
		
		if (usuario.getDeEmailId() == null || "".equals(usuario.getDeEmailId())) { 
			throw new IllegalArgumentException("Senha do usuário deve ser preenchida");
		}
	}
	
	
	

}
