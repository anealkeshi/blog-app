package com.anilkc.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("credentialService")
	UserDetailsService credentialService;

	@Autowired
	@Bean
	public AuthenticationManager configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(credentialService).passwordEncoder(passwordEncoder());
		return authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/posts/**").access("hasRole('ROLE_USER')")
		.and().formLogin()
		.loginPage("/login")
		.failureUrl("/login?error")
		.loginProcessingUrl("/j_spring_security_check")
		.usernameParameter("username")
		.passwordParameter("password")
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/doLogout"))
		.logoutSuccessUrl("/login?logout")
		.and()
		.csrf()
		.and()
		.exceptionHandling()
		.accessDeniedPage("/403");
	}

	@Bean
	public org.springframework.security.authentication.encoding.PasswordEncoder passwordEncoder() {
		PlaintextPasswordEncoder encoder = new PlaintextPasswordEncoder();
		return encoder;
	}
}