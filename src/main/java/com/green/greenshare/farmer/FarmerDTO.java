package com.green.greenshare.farmer;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FarmerDTO {
  private int boardNum;
  private String title;
  private String writer;
  private String content;
  private  int views;
  private LocalDateTime date;
}
