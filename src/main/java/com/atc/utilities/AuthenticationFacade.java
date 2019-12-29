package com.atc.utilities;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
  
  Authentication getAuthentication();
  
}
