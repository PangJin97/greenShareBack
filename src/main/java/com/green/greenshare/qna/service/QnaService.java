package com.green.greenshare.qna.service;

import com.green.greenshare.qna.dto.QnaDTO;

import java.util.List;

public interface QnaService {
  //qna 질문 목록 조회
  public List<QnaDTO> qnaList(QnaDTO userDTO);

  //qna 질문 상세 조회
  public QnaDTO selectQna(int qnaNum);

  //qna 질문 등록
  public int insertQna(QnaDTO userDTO);

  //qna 글 수정
  public int updateQna(QnaDTO userDTO);

  //qna 글 삭제
  public int deleteQna(int qnaNum);
}
