package com.green.greenshare.User.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class UserDTO {
  private String userEmail;
  private String userPassword;
  private String userTel;
  private String userRole;
  private LocalDateTime joinData;
  private String userName;


}
