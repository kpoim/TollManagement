package com.atc.config;

import com.atc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
public class MyWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

  @Autowired
  UserService userService;
  
  @Autowired
  AuthenticationSuccessHandler successHandler;
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.authenticationProvider(authenticationProvider());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/employee/**").hasRole("EMPLOYEE")
		.antMatchers("/user/**").hasRole("CLIENT")
		.antMatchers("/card/*").hasAnyRole("TERMINAL", "CLIENT")
		.antMatchers("/").permitAll()
		.and()
		.formLogin()
		.successHandler(successHandler)
		.loginProcessingUrl("/authenticate")
		.permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/access-denied");
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
	auth.setUserDetailsService(userService);
	auth.setPasswordEncoder(passwordEncoder());
	return auth;
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
  }

}
