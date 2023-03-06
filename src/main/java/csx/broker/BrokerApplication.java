package csx.broker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
=======
>>>>>>> de115e2fe6ccd23ac7d8b0d35f19cdd7d17bae5e

@SpringBootApplication
public class BrokerApplication {

	public static void main(String[] args) {
<<<<<<< HEAD
		SpringApplication.run(BrokerApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET","PUT","POST","DELETE");
			}
		};
	}

=======

		SpringApplication.run(BrokerApplication.class, args);
	}

>>>>>>> de115e2fe6ccd23ac7d8b0d35f19cdd7d17bae5e
}
