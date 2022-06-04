package dwaki.convertcurrency.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ConvertCurrencyAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		System.out.println("Inside Initializer...");

		AnnotationConfigWebApplicationContext container = new AnnotationConfigWebApplicationContext();
		container.register(ConvertCurrencyAppConfig.class);

		DispatcherServlet servlet = new DispatcherServlet(container);
		ServletRegistration.Dynamic addServlet = servletContext.addServlet("convertCurrencyServlet", servlet);

		addServlet.addMapping("/*");
		addServlet.setLoadOnStartup(1);

	}

}
