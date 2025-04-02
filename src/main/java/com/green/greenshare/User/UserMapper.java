package com.green.greenshare.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

  public void insertUserList(UserDTO userDTO);

}
