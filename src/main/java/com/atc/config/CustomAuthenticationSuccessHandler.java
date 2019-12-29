package com.atc.config;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

  @Override
  public void onAuthenticationSuccess(HttpServletRequest hsr, HttpServletResponse hsr1, Authentication a) throws IOException, ServletException {
	
	Collection<? extends GrantedAuthority> collection = a.getAuthorities();
	collection.forEach(auth -> {
	  String url = "404";
	  switch(auth.getAuthority()){
		case "ROLE_ADMIN":
		  url = "/admin";
		  break;
		case "ROLE_CLIENT":
		  url = "/client";
		  break;
		case "ROLE_EMPLOYEE":
		  url = "/employee";
		  break;
		case "ROLE_TERMINAL":
		  url = "/terminal";
		  break;
	  }
	  try {
		redirectStrategy.sendRedirect(hsr, hsr1, url);
	  } catch (IOException ex) {}
	});
  }

}
