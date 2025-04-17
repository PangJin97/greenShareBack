package com.green.greenshare.qna.mapper;

import com.green.greenshare.qna.dto.ReplyQnaDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyQnaMapper {
  //댓글 조회
  public List<ReplyQnaDTO> replySelect(int qnaNum);

  //댓글 등록
  public int insertReply(ReplyQnaDTO replyQnaDTO);

  //댓글 삭제
  public int deleteReply(int replyNum);
}
