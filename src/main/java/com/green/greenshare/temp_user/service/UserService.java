package com.green.greenshare.user.service;

import com.green.greenshare.user.dto.UserDTO;

import java.util.List;

/**
 * CreatedBy 최재훈
 * last-update : 2025.04.11
 */
public interface UserService {
  //회원가입
  public void insertUserList(UserDTO userDTO);

  //로그인하려는 회원의 정보 조회
  public UserDTO getUserForLogin(String userEmail);
}
