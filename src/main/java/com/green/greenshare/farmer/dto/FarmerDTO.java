package com.green.greenshare.farmer.dto;

import com.green.greenshare.farmer.ReplyFarmersDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FarmerDTO {
  private int boardNum;
  private String title;
  private String userEmail;
  private String content;
  private int views;
  private LocalDateTime date;
  private String selectWord;
  private String searchLog;
  private ReplyFarmersDTO replyFarmersDTO;
  private boolean latest;
}
