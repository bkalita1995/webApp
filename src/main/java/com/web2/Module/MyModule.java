package com.web2.Module;


import com.google.inject.servlet.ServletModule;
import com.web2.Servlet.InsertFind;

public class MyModule extends ServletModule{
		@Override
		protected void configureServlets() {
			serve("/*.html").with(InsertFind.class);
		}

}
