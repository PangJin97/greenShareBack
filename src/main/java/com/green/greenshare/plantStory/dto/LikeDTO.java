package com.green.greenshare.plantStory.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LikeDTO {
  private int likeNum;
  private int boardNum;
  private String userEmail;
}
