package com.maldives.resources;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class PacoteRecurso {
	
	public static String LOCALE_PORTUGUES_BRASIL = "pt-BR";
	private static PacoteRecurso pacoteRecurso = null;
	private ResourceBundle resorceBundle = null;
	
	private PacoteRecurso() {
		this.initializeResourceBundle();
	}

	public static PacoteRecurso getPacoteRecurso() {
		if (pacoteRecurso == null) {
			pacoteRecurso = new PacoteRecurso();
		}
		return pacoteRecurso;
	}
	
	private void initializeResourceBundle() {
		
		Locale defautLocale = Locale.getDefault();
		Locale locale_pt_BR = new Locale(LOCALE_PORTUGUES_BRASIL);
		
		if (defautLocale.equals(locale_pt_BR)) {
			resorceBundle =  ResourceBundle.getBundle("com.maldives.resources.bundle_pt_BR");
		} else {
			throw new InternalError("Resource Bundle não foi identificado para lingua '" + defautLocale.getLanguage()+"_"+defautLocale.getCountry()+"'.");
		}
		
	}
	
	public String getLabel(String key) {
		return resorceBundle.getString(key);
	}
	
	public void showAllLabels() {
		Enumeration<String> bundleKeys = resorceBundle.getKeys();
		while (bundleKeys.hasMoreElements()) {
		    String bundleKey = (String)bundleKeys.nextElement();
		    String value = resorceBundle.getString(bundleKey);
		    System.out.println("key = " + bundleKey + ", " + "value = " + value);
		}
	}
	
	public static void main(String[] args) {
		Locale.setDefault(new Locale(LOCALE_PORTUGUES_BRASIL));
		PacoteRecurso.getPacoteRecurso().showAllLabels();
		System.out.println(PacoteRecurso.getPacoteRecurso().getLabel("empresa.nmempresa.embranco"));
	}
	

}
