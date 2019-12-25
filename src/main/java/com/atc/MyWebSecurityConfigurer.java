package com.atc;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

//@Configuration
@EnableWebSecurity
public class MyWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

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
		.withUser(userBuilder.username("terminal").password("{noop}1234").roles("TERMINAL"))
		.withUser(userBuilder.username("terminal2").password("{noop}1234").roles("TERMINAL"));

  }

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//	http.authorizeRequests()//Restrict access based on HttServletRequest
//		//.anyRequest().authenticated()//Any request to the app must be authenticated(logged in)
//		.antMatchers("/").hasAnyRole("USER", "ADMIN")
//		.antMatchers("/admin/**").hasRole("ADMIN")
//		.antMatchers("/*/create/**", "/*/update/**", "/*/delete/**").hasRole("ADMIN")
//		.and()
//		.formLogin()//We are customizing the form login process
//		.loginPage("/loginPage")//Show my form at the request mapping
//		.loginProcessingUrl("/authenticate")//Login form will POST data to this URL for processing username and password
//		.permitAll()//Allow everyone to see Login page. Don't have to be logged in.
//		.and().logout().permitAll()
//		.and().exceptionHandling().accessDeniedPage("/access-denied");
//  }
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
