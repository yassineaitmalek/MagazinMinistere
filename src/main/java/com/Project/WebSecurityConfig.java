package com.Project;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new Userservice();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.authorizeRequests()
		
			.antMatchers("/dashboard/").authenticated()
			.antMatchers("/dashboard/admin/**").hasAnyAuthority("admin")
			.antMatchers("/dashboard/employee/**").hasAnyAuthority("employee")
			.antMatchers("/dashboard/chef_ser/**").hasAnyAuthority("chef_ser")
			.antMatchers("/dashboard/chef_div/**").hasAnyAuthority("chef_div")
			.antMatchers("/dashboard/directeur/**").hasAnyAuthority("directeur")
			.antMatchers("/dashboard/magasinier/**").hasAnyAuthority("magasinier")
			.anyRequest().permitAll()
			.and()
			.formLogin()
				.loginPage("/signin")
				.usernameParameter("email")
				.passwordParameter("password")
				
				.defaultSuccessUrl("/dashboard/check")
				.permitAll()
			.and()
			.logout().logoutSuccessUrl("/").permitAll()
			.and()
			.csrf().disable()
			;
	
		
	}
	
	
	
	
}
