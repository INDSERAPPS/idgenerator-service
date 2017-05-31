package tcs.ms.poc.idgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class IdgeneratorApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(IdgeneratorApplication.class, args);
	}
	
	  @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(IdgeneratorApplication.class);
	    }

	 //   private static Class<IdgeneratorApplication> applicationClass = IdgeneratorApplication.class;
}
