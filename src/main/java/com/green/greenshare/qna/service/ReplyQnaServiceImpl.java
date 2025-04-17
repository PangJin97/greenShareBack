package com.green.greenshare.qna.service;

import com.green.greenshare.qna.dto.ReplyQnaDTO;
import com.green.greenshare.qna.mapper.QnaMapper;
import com.green.greenshare.qna.mapper.ReplyQnaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyQnaServiceImpl implements  ReplyQnaService {
  private final ReplyQnaMapper replyQnaMapper;


  @Override
  public List<ReplyQnaDTO> replySelect(int qnaNum) {
    return replyQnaMapper.replySelect(qnaNum);
  }

  @Override
  public int insertReply(ReplyQnaDTO replyQnaDTO) {
    return replyQnaMapper.insertReply(replyQnaDTO);
  }

  @Override
  public int deleteReply(int replyNum) {
    return replyQnaMapper.deleteReply(replyNum);
  }
}
