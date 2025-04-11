package com.green.greenshare.user.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * CreatedBy 최재훈
 * last-update : 2025.04.11
 */
@Data
public class UserDTO {
  private String userEmail;
  private String userPassword;
  private String userTel;
  private String userRole;
  private LocalDateTime joinData;
  private String userName;
}
