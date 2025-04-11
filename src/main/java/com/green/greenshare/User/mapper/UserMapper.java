package com.green.greenshare.User.mapper;

import com.green.greenshare.User.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  public int insertUserList(UserDTO userDTO);

  public UserDTO getUserForLogin (String userEmail);

}
