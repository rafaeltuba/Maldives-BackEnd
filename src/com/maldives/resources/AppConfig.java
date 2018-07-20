package com.maldives.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maldives.repository.EmpresaDB;
import com.maldives.repository.UsuarioDB;
import com.maldives.service.EmpresaService;
import com.maldives.service.UsuarioService;

@Configuration
public class AppConfig {
	
	@Bean
    public EmpresaService empresaService() {
		System.out.println("empresaService inicializado...");
        return new EmpresaService();
    }
	
	@Bean
    public EmpresaDB empresaDB() {
		System.out.println("empresaDB inicializado...");
        return new EmpresaDB();
    }
	
	@Bean
    public UsuarioDB usuarioDB() {
		System.out.println("usuarioDB inicializado...");
        return new UsuarioDB();
    }
	
	@Bean
    public UsuarioService usuarioService() {
		System.out.println("usuarioService inicializado...");
        return new UsuarioService();
    }
	
}
