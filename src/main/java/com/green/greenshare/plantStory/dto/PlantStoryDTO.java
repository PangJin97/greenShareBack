package com.green.greenshare.plantStory.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PlantStoryDTO {
  private int boardNum;
  private String title;
  private String content;
  private int readCnt;
  private LocalDateTime regDate;
  private String userEmail;
  private String isLike;
  private int likeCnt;
  private int replyCnt;
  private String isFollow;
}
