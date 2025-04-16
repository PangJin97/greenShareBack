package com.green.greenshare.note.service;

import com.green.greenshare.note.dto.MessageDTO;

import java.util.List;

public interface MessageService {

  public int insertNote(MessageDTO messageDTO);

  public List<MessageDTO> selectReceivedNotes(String receiverEmail);
}
