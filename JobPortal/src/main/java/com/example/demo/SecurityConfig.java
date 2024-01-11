package com.example.demo;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService useService() {
		
		UserDetails firstuser=User
				.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("USER","ADMIN")
				.build();
		
		
		
		InMemoryUserDetailsManager data=new InMemoryUserDetailsManager(firstuser);
		
		return data;
	}
	@Bean
	public SecurityFilterChain setPermissions(HttpSecurity http)throws Exception {
		return http
				.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(authorize->
				authorize.requestMatchers(HttpMethod.POST,"/jobs").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE,"/jobs/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT,"/jobs/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET,"/jobs").permitAll()
				.requestMatchers(HttpMethod.GET,"/jobs").hasRole("ADMIN")
				.requestMatchers(HttpMethod.POST,"/users").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE,"/users/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT,"/users/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET,"/users").hasRole("ADMIN")
				.anyRequest()
				.authenticated())
				.httpBasic(withDefaults())
				.build();
				
				
	}
}
