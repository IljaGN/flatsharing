package com.myght.flatsharing.models.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
  OWNER,
  CUSTOMER;

  @Override
  public String getAuthority() {
    return name();
  }
}
