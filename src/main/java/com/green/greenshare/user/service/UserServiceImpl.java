package com.green.greenshare.user.service;

import com.green.greenshare.user.dto.UserDTO;
import com.green.greenshare.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
  private final UserMapper userMapper;

  @Override
  public List<UserDTO> qnaList(UserDTO userDTO) {
    return userMapper.qnaList(userDTO);
  }

  @Override
  public UserDTO selectQna(int qnaNum) {
    return userMapper.selectQna(qnaNum);
  }

  @Override
  public int insertQna(UserDTO userDTO) {
    return userMapper.insertQna(userDTO);
  }

  @Override
  public int updateQna(UserDTO userDTO) {
    return userMapper.updateQna(userDTO);
  }

  @Override
  public int deleteQna(int qnaNum) {
    return userMapper.deleteQna(qnaNum);
  }
}