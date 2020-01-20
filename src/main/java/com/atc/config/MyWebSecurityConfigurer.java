package com.atc.config;

import com.atc.service.UserService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

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
	http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/employee/**").hasRole("EMPLOYEE")
		.antMatchers("/user/**").hasRole("CLIENT")
//		.antMatchers("/terminal-api/**").hasRole("TERMINAL")
		.antMatchers("/card/*").hasAnyRole("TERMINAL", "CLIENT")
		.antMatchers("/**").permitAll()
		.and()
		.cors()
		.and()
		.formLogin().loginPage("/login")
		.successHandler(successHandler)
		.loginProcessingUrl("/authenticate")
		.permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/access-denied");
  }
  
  @Bean
  CorsConfigurationSource corsConfigurationSource() {
      CorsConfiguration configuration = new CorsConfiguration();
      configuration.setAllowedOrigins(Arrays.asList("*"));
      configuration.setAllowedMethods(Arrays.asList("GET","POST"));
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", configuration);
      return source;
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
