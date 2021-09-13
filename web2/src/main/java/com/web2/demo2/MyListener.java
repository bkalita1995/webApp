package com.web2.demo2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class MyListener extends GuiceServletContextListener{

	@Override
	protected Injector getInjector() {
		
		return Guice.createInjector(new MyModule());
	}
		
	

}
