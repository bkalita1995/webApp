package com.web2.Listener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.web2.Module.MyModule;

public class MyListener extends GuiceServletContextListener{

	@Override
	protected Injector getInjector() {
		
		return Guice.createInjector(new MyModule());
	}
		
	

}
