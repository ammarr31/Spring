package com.springgg.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.spring.core")
public class JavaConfig {
	@Bean("personn")
    public PersonService personService() {
        return new PersonService();
    }
}
