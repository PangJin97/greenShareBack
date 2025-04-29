package com.green.greenshare.message.DTO;

import com.green.greenshare.user.dto.UserDTO;
import lombok.Data;

@Data
public class ThreadDTO {
  private Long id;
  private String sender;
  private String receiver;
  private String chatName;
  private String createdAt;
}
