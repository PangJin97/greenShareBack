package com.green.greenshare.user.service;

import com.green.greenshare.user.dto.UserDTO;
import com.green.greenshare.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CreatedBy 최재훈
 * last-update : 2025.04.11
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
  private final UserMapper userMapper;

  //회원가입
  @Override
  public void insertUserList(UserDTO userDTO) {
    userMapper.insertUserList(userDTO);
  }

  //로그인하려는 회원의 정보조회
  @Override
  public UserDTO getUserForLogin(String userEmail) {
    return userMapper.getUserForLogin(userEmail);
  }
}