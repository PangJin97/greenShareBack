package com.green.greenshare.qna.service;

import com.green.greenshare.qna.dto.ReplyQnaDTO;
import com.green.greenshare.qna.mapper.QnaMapper;

import java.util.List;

public interface ReplyQnaService {
  //댓글 조회
  public List<ReplyQnaDTO> replySelect(int qnaNum);

  //댓글 등록
  public int insertReply(ReplyQnaDTO replyQnaDTO);

  //댓글 삭제
  public int deleteReply(int replyNum);
  }

