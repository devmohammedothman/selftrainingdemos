package com.selftraining.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.selftraining.dao.ICarRepository;
import com.selftraining.model.Car;


@SpringBootApplication
@ComponentScan (value = {"com.selftraining.controller","com.selftraining.services","com.selftraining.conf","com.selftraining.aspects"})
@EntityScan ("com.selftraining.model")
@EnableJpaRepositories ("com.selftraining.dao") 
@EnableAspectJAutoProxy
public class Angularspringh2jpaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Angularspringh2jpaApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(ICarRepository repository)
	{
		return args -> {
			
			List<Car> carInitList = new ArrayList<Car>();
			
			carInitList.add(new Car("Ferrari","250 GT California","250 GT California"));
			carInitList.add(new Car("Jaguar","XJ Saloon SWB","XJ Saloon SWB"));
			carInitList.add(new Car("Porsche","Boxster","Boxster"));
			carInitList.add(new Car("Lamborghini","Gallardo","Gallardo"));
			carInitList.add(new Car("Dodge","Challenger","Challenger"));
			carInitList.add(new Car("Ford","Focus",""));
			
			carInitList.stream().forEach(item -> repository.save(item));
		};
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Angularspringh2jpaApplication.class);
	}
	
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() 
	{
	    return factory -> factory.setContextPath("/angularspringh2jpa");
	}
}
