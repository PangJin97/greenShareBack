package com.green.greenshare.User.service;

import com.green.greenshare.User.dto.UserDTO;
import com.green.greenshare.User.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService{
  private final UserMapper userMapper;


  @Override
  public int insertUserList(UserDTO userDTO) {
   return userMapper.insertUserList(userDTO);
  }

  @Override
  public UserDTO getUserForLogin(String userEmail) {
    return userMapper.getUserForLogin(userEmail);
  }
}
