package com.green.greenshare.note.mapper;

import com.green.greenshare.note.dto.MessageDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

  /*쪽지 저장*/
  public int insertNote(MessageDTO messageDTO);

  /*받은 쪽지 리스트 조회*/
  public List<MessageDTO> selectReceivedNotes(String receiverEmail);

  /*쪽지 삭제*/
  public int deleteNote(int id);

}
