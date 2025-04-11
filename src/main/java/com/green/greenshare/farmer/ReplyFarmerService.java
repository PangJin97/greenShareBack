package com.green.greenshare.farmer;

import java.util.List;

public interface ReplyFarmerService {
  //댓글 조회
  public List<ReplyFarmersDTO> replySelect(int boardNum);

  //댓글 등록
  public int insertReply(ReplyFarmersDTO replyFarmersDTO);

  //댓글 삭제
  public int deleteReply(int replyNum);

}
