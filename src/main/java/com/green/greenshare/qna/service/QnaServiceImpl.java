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

  //목록조회
  @Override
  public List<QnaDTO> qnaList(QnaDTO userDTO) {
    return qnaMapper.qnaList(userDTO);
  }

  //qna 목록 최대 5개까지 조회
  @Override
  public List<QnaDTO> mainQna() {
    return qnaMapper.mainQna();
  }

  //목록 상세조회
  @Override
  public QnaDTO selectQna(int qnaNum) {
    return qnaMapper.selectQna(qnaNum);
  }


  //등록
  @Override
  public int insertQna(QnaDTO userDTO) {
    return qnaMapper.insertQna(userDTO);
  }

  //수정
  @Override
  public int updateQna(QnaDTO userDTO) {
    return qnaMapper.updateQna(userDTO);
  }


  //삭제
  @Override
  public int deleteQna(int qnaNum) {
    return qnaMapper.deleteQna(qnaNum);
  }
}
