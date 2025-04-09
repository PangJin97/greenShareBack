package com.green.greenshare.user;

import com.green.greenshare.farmer.ReplyFarmersDTO;
import lombok.Data;

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
