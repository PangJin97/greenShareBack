package com.green.greenshare.plantStory.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
//외래 키(Foreign Key)를 DB에 설정하더라도,
//DTO 클래스에서는 기존처럼 평범한 필드로 작성하면 된다
public class PlantStoryReplyDTO {
  private int commentId;
  private String content;
  private int boardNum;
  private String userEmail;
  private LocalDateTime regDate;
}
