package com.green.greenshare.plantStory.service;

import com.green.greenshare.plantStory.dto.PlantStoryReplyDTO;
import com.green.greenshare.plantStory.mapper.PlantStoryReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantStoryReplyServiceImpl implements PlantStoryReplyService {
  private final PlantStoryReplyMapper plantStoryReplyMapper;

  /*댓글 등록*/
  @Override
  public int insertReply(PlantStoryReplyDTO plantStoryReplyDTO) {
    return plantStoryReplyMapper.insertReply(plantStoryReplyDTO);
  }

  /*게시글 당 댓글 목록 조회*/
  @Override
  public List<PlantStoryReplyDTO> getReplies(int boardNum) {
    return plantStoryReplyMapper.getReplies(boardNum);
  }

 /*댓글 삭제*/
  @Override
  public int deleteReply(int commentId) {
    return plantStoryReplyMapper.deleteReply(commentId);
  }
}
