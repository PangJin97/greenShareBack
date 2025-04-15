package com.green.greenshare.follow.dto;


import com.green.greenshare.user.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class FollowDTO {
  private int followId;
  private String fromUserEmail;
  private String toUserEmail;
  private LocalDateTime followDate;

  private UserDTO user;
}
