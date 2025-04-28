package com.green.greenshare.user.service;

import com.green.greenshare.user.dto.UserDTO;
import com.green.greenshare.user.manager.OnlineUserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CreatedBy 최재훈
 * last-update : 2025.04.11
 */

@Service
public interface UserService {


  //회원가입
  public void insertUserList(UserDTO userDTO);

  //로그인하려는 회원의 정보 조회
  public UserDTO getUserForLogin(String userEmail);


  // ✅ 수신자 온라인 여부 확인
  boolean isUserOnline(String userEmail);

}
