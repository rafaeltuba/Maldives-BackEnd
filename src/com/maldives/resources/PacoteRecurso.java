package com.maldives.resources;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class PacoteRecurso {
	
	public static String LOCALE_PORTUGUES_BRASIL = "pt-BR";
	
	private static PacoteRecurso pacoteRecurso = null;
	private ResourceBundle resourceBundle = null;
	private Locale locale = null;
	
	private PacoteRecurso() {
		locale = Locale.getDefault();
		initializeResourceBundle();
	}

	public static PacoteRecurso getPacoteRecurso() {
		if (pacoteRecurso == null) {
			pacoteRecurso = new PacoteRecurso();
		}
		return pacoteRecurso;
	}
	
	public Locale getLocale() {
		return this.locale;
	}
	
	private void initializeResourceBundle() {
		this.locale = Locale.getDefault();
		
		Locale locale_pt_BR = new Locale(LOCALE_PORTUGUES_BRASIL);
		
		if (this.locale.equals(locale_pt_BR)) {
			resourceBundle =  ResourceBundle.getBundle("com.maldives.resources.bundle_pt_BR");
		} else {
			throw new InternalError("Resource Bundle não foi identificado para lingua '" + this.locale.getLanguage()+"_"+this.locale.getCountry()+"'.");
		}
	}
	
	public boolean isLocaleDiferente() {
		return ! locale.equals(Locale.getDefault());
	}
	
	public String getLabel(String key) {
		if (isLocaleDiferente()) initializeResourceBundle();
		return resourceBundle.getString(key);
	}

}
