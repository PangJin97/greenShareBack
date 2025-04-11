package com.green.greenshare.user.mapper;

import com.green.greenshare.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

  //qna 질문 목록 조회
  public List<UserDTO> qnaList(UserDTO userDTO);

  //qna 질문 상세 조회
  public UserDTO selectQna(int qnaNum);

  //qna 질문 등록
  public int insertQna(UserDTO userDTO);

  //qna 글 수정
  public int updateQna(UserDTO userDTO);

  //qna 글 삭제
  public int deleteQna(int qnaNum);


}
