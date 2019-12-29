package com.atc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

//@Configuration
@EnableWebSecurity
public class MyWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

  @Autowired
  AuthenticationSuccessHandler successHandler;
  
//  @Autowired
//  private DataSource datasource;
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	UserBuilder userBuilder = User.builder();
//	auth.jdbcAuthentication().dataSource(datasource);
//	auth.authenticationProvider(authenticationProvider());
	auth.inMemoryAuthentication()
		.withUser(userBuilder.username("admin").password("{noop}1234").roles("ADMIN"))
		.withUser(userBuilder.username("user").password("{noop}1234").roles("USER"))
		.withUser(userBuilder.username("employee").password("{noop}1234").roles("EMPLOYEE"))
		.withUser(userBuilder.username("terminal1").password("{noop}1234").roles("TERMINAL"))
		.withUser(userBuilder.username("terminal100").password("{noop}1234").roles("TERMINAL"));

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
//
//  @Bean
//  public DaoAuthenticationProvider authenticationProvider() {
//	DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//	auth.setUserDetailsService(userService);
//	auth.setPasswordEncoder(passwordEncoder());
//	return auth;
//  }
//
//  @Bean
//  public BCryptPasswordEncoder passwordEncoder() {
//	return new BCryptPasswordEncoder();
//  }

}
