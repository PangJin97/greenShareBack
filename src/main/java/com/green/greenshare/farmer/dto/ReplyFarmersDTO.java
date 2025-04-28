package com.green.greenshare.farmer.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReplyFarmersDTO {
  private int replyNum;
  private String content;
  private String userEmail;
  private LocalDateTime date;
  private int boardNum;
}
