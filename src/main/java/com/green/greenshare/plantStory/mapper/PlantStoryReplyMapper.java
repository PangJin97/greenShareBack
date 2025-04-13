package com.green.greenshare.plantStory.mapper;

import com.green.greenshare.plantStory.dto.PlantStoryDTO;
import com.green.greenshare.plantStory.dto.PlantStoryReplyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlantStoryReplyMapper {

  /*댓글 등록*/
  public int insertReply(PlantStoryReplyDTO plantStoryReplyDTO);

  /*게시글 당 댓글 조회*/
  public List<PlantStoryReplyDTO>getReplies(int boardNum);

  /*댓글 삭제*/
  public int deleteReply(int commentId);

}
