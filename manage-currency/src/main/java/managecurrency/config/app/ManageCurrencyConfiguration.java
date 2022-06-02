package managecurrency.config.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScans(value = { @ComponentScan(basePackages = "managecurrency.controller"), 
	@ComponentScan(basePackages = "managecurrency.model"),
	@ComponentScan(basePackages = "managecurrency.service"),
	@ComponentScan(basePackages = "managecurrency.config.*")})
public class ManageCurrencyConfiguration {

}
