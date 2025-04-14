package com.green.greenshare.plantStory.service;

import com.green.greenshare.plantStory.dto.PlantStoryReplyDTO;

import java.util.List;

public interface PlantStoryReplyService {

  /*댓글 등록*/
  int insertReply(PlantStoryReplyDTO plantStoryReplyDTO);

  /*게시글 당 댓글 조회*/
  List<PlantStoryReplyDTO> getReplies(int boardNum);

  /*댓글 삭제*/
  int deleteReply(int commentId);

  /*댓글 수정*/
  int updateReply(PlantStoryReplyDTO plantStoryReplyDTO);

  /*댓글 작성자 이메일 조회 (권한 체크용)*/
  String getReplyWriter(int commentId);
}
