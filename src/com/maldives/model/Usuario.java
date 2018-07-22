package com.maldives.model;

public class Usuario {
	
	public static final String TPUSUARIO_CANDIDATO = "C";
	public static final String TPUSUARIO_EMPRESA = "E";

	private Integer idUsuario;
	private String deEmailId;
	private String deSenha;
	private String tpUsuario;
	private Integer idEmpresa;
	
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getDeEmailId() {
		return deEmailId;
	}
	public void setDeEmailId(String deEmailId) {
		this.deEmailId = deEmailId;
	}
	public String getDeSenha() {
		return deSenha;
	}
	public void setDeSenha(String deSenha) {
		this.deSenha = deSenha;
	}
	public String getTpUsuario() {
		return tpUsuario;
	}
	public void setTpUsuario(String tpUsuario) {
		this.tpUsuario = tpUsuario;
	}

}
