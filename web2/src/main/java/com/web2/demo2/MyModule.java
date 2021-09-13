package com.web2.demo2;

import com.google.inject.servlet.ServletModule;


public class MyModule extends ServletModule{
		@Override
		protected void configureServlets() {
			serve("/*.html").with(MyServlet.class);
		}

}
