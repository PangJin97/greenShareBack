package com.green.greenshare.qna.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class QnaDTO {
  private int qnaNum;
  private String status;
  private String title;
  private String writer;
  private String content;
  private LocalDateTime date;
  private String searchLog;
  private String selectWord;
  private boolean qnaTest;
}
