package com.green.greenshare.note.service;

import com.green.greenshare.note.dto.MessageDTO;

import java.util.List;

public interface MessageService {

  /*채팅 기록 등록(송수신)*/
  public int insertNote(MessageDTO messageDTO);

  /* 채팅 이력 조회*/
  public List<MessageDTO> selectReceivedNotes(String receiverEmail);

  /**/
  public int deleteNote(int id);
}
