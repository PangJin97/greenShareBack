package com.green.greenshare.plantStory.service;

import com.green.greenshare.plantStory.dto.PlantStoryReplyDTO;

import java.util.List;

public interface PlantStoryReplyService {

  /*댓글 등록*/
  public int insertReply(PlantStoryReplyDTO plantStoryReplyDTO);

  /*게시글 당 댓글 조회*/
  public List<PlantStoryReplyDTO> getReplies(int boardNum);

  /*댓글 삭제*/
  public int deleteReply(int commentId);
}
