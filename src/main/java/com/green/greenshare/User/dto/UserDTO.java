package com.green.greenshare.user.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
public class UserDTO {
  private int qnaNum;
  private String status;
  private String title;
  private String writer;
  private String content;
  private LocalDateTime date;
  private String searchLog;
  private String selectWord;
}
