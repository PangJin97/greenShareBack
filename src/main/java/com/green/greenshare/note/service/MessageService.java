package com.green.greenshare.note.service;

import com.green.greenshare.note.dto.MessageDTO;

import java.util.List;

public interface MessageService {

  /*쪽지 등록(송수신)*/
  public int insertNote(MessageDTO messageDTO);

  /*쪽지 목록 조회*/
  public List<MessageDTO> selectReceivedNotes(String receiverEmail);

  /*본인의 쪽지 삭제*/
  public int deleteNote(int id);
}
