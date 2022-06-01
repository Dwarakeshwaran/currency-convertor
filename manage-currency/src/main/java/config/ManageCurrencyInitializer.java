package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ManageCurrencyInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		System.out.println("Inside Initialiser");

		AnnotationConfigWebApplicationContext container = new AnnotationConfigWebApplicationContext();
		container.register(ManageCurrencyConfigiration.class);

		DispatcherServlet servlet = new DispatcherServlet(container);
		ServletRegistration.Dynamic customServlet = servletContext.addServlet("manageCurrencyServlet", servlet);

		customServlet.setLoadOnStartup(1);
		customServlet.addMapping("/*");

	}

}
