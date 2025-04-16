package com.green.greenshare.farmer;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
public class ReplyFarmersDTO {
  private int replyNum;
  private String content;
  private String userEmail;
  private LocalDateTime date;
  private int boardNum;
}
