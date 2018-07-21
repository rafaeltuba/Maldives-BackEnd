package com.maldives.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maldives.model.Empresa;
import com.maldives.repository.EmpresaDB;
import com.maldives.resources.PacoteRecurso;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaDB empresaDB;
	
	public boolean registrarNovaEmpresa(Empresa empresa) {
		
		if (empresa.getNmEmpresa() == null || "".equals(empresa.getNmEmpresa())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("empresa.nome.empresa.embranco"));
		}
		
		if (empresa.getDeEmail() == null || "".equals(empresa.getDeEmail())) { 
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("empresa.email.embranco"));
		}
		
		if (empresa.getCdRamoAtividade() == null) {
			throw new IllegalArgumentException(PacoteRecurso.getPacoteRecurso().getLabel("empresa.ramo.atividade.embranco"));
		}
		return this.save(empresa);
	}
	
	public Empresa findByEmail(final String email) {
		return empresaDB.findByEmail(email);
	}
	
	public void deleteAll() {
		try {
			empresaDB.deleteAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean save(Empresa empresa) {
		return empresaDB.save(empresa);
	}

	public void setEmpresaDB(EmpresaDB empresaDB) {
		this.empresaDB = empresaDB;
	}
	
}
