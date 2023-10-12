package com.photoapp.users.PhotoAppApiUsers.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSercurity {

	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
	
		//new WebE
		http.csrf().disable();
		//http.authorizeHttpRequests().antMatchers(HttpMethod.POST, "/users").access(new WebE)
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/users").permitAll()
		.requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.headers().frameOptions().disable();
		return http.build();
	}
}
