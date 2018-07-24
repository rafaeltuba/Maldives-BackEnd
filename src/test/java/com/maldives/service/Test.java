package com.maldives.service;

import java.util.Locale;

import com.maldives.resources.PacoteRecurso;

public abstract class Test {
	
	public Test() {
		Locale.setDefault(new Locale(PacoteRecurso.LOCALE_PORTUGUES_BRASIL));
	}

}
