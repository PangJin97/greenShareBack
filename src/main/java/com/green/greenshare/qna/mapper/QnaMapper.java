package com.green.greenshare.qna.mapper;

import com.green.greenshare.qna.dto.QnaDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnaMapper {
  //qna 질문 목록 조회
  public List<QnaDTO> qnaList(QnaDTO userDTO);

  //qna 목록 최대 5개까지 조회
  public  List<QnaDTO> mainQna();

  //qna 질문 상세 조회
  public QnaDTO selectQna(int qnaNum);

  //qna 질문 등록
  public int insertQna(QnaDTO userDTO);

  //qna 글 수정
  public int updateQna(QnaDTO userDTO);

  //qna 글 삭제
  public int deleteQna(int qnaNum);

  //조회수 증가
  public  int updateViews(int qnaNum);

}
