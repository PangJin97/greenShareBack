package com.green.greenshare.farmer;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyFarmerMapper {

  //댓글 조회
  public List<ReplyFarmersDTO> replySelect(int boardNum);

  //댓글 등록
  public int insertReply(ReplyFarmersDTO replyFarmersDTO);

  //댓글 삭제
  public int deleteReply(int replyNum);
}
