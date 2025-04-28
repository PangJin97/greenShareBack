package com.green.greenshare.user.service;

import com.green.greenshare.user.dto.UserDTO;
import com.green.greenshare.user.manager.OnlineUserManager;
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
  private final OnlineUserManager onlineUserManager;

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

  // ✅ 수신자 온라인 여부 확인
  @Override
  public boolean isUserOnline(String userEmail) {
    return onlineUserManager.isConnected(userEmail);
  }


}