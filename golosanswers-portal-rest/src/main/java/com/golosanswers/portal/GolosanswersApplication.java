package com.golosanswers.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@SpringBootApplication incapsulate @ComponentScan annotation and placed in com.golosanswers.portal package.
//Thats means what everything what placed under com.golosanswers.portal package will recursively scanned on startup.
//Each related maven project have com.golosanswers.portal as root directory too and automatically added to ApplicationContext.
//Also @SpringBootApplication incapsulate @EnableAutoConfiguration which incapsulate a lot of auto-configuration beans
//include nessesary staff for jpa repositories / json serialization / etc.
@SpringBootApplication
public class GolosanswersApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(GolosanswersApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		return builder.sources(GolosanswersApplication.class);
	}
}
