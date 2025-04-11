package com.green.greenshare.user.mapper;

import com.green.greenshare.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * CreatedBy 최재훈
 * last-update : 2025.04.11
 */
@Mapper
public interface UserMapper {
  //회원가입
  public void insertUserList(UserDTO userDTO);

  //로그인하려는 회원의 정보 조회
  public UserDTO getUserForLogin(String userEmail);
}
