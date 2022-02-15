package com.Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;



@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableWebSecurity
public class ProjetSpringDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetSpringDataApplication.class, args);
	}

}
