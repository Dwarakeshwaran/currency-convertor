package managecurrency.config.app;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScans(value = { @ComponentScan(basePackages = "managecurrency.controller"),
		@ComponentScan(basePackages = "managecurrency.model"), @ComponentScan(basePackages = "managecurrency.service"),
		@ComponentScan(basePackages = "managecurrency.config.*") })
public class ManageCurrencyConfiguration implements WebMvcConfigurer {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET", "POST");
	}

}
