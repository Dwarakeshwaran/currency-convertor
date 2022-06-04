package dwaki.convertcurrency.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "dwaki.convertcurrency.*")
public class ConvertCurrencyAppConfig {
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
