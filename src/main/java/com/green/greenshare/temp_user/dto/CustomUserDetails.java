package com.green.greenshare.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Getter  // 추가 (userDTO 접근 가능하게)
@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {
  private final UserDTO userDTO;

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> collection = new ArrayList<>();
    collection.add(() -> userDTO.getUserRole());
    return collection;
  }

  @Override
  public String getPassword() {
    return userDTO.getUserPasswod();
  }

  @Override
  public String getUsername() {
    return userDTO.getUserEmail();
  }
}
