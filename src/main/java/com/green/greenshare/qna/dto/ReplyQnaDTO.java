package com.green.greenshare.qna.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReplyQnaDTO {
  private int replyNum;
  private String  content;
  private String writer;
  private LocalDateTime date;
  private  int qnaNum;
}
