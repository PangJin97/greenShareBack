package com.green.greenshare.qna.service;

import com.green.greenshare.qna.dto.QnaDTO;
import com.green.greenshare.qna.mapper.QnaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QnaServiceImpl implements QnaService{
  private final QnaMapper qnaMapper;

  @Override
  public List<QnaDTO> qnaList(QnaDTO userDTO) {
    return qnaMapper.qnaList(userDTO);
  }

  @Override
  public QnaDTO selectQna(int qnaNum) {
    return qnaMapper.selectQna(qnaNum);
  }

  @Override
  public int insertQna(QnaDTO userDTO) {
    return qnaMapper.insertQna(userDTO);
  }

  @Override
  public int updateQna(QnaDTO userDTO) {
    return qnaMapper.updateQna(userDTO);
  }

  @Override
  public int deleteQna(int qnaNum) {
    return qnaMapper.deleteQna(qnaNum);
  }
}
