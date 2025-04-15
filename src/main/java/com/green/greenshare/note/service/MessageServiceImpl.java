package com.green.greenshare.note.service;

import com.green.greenshare.note.dto.MessageDTO;
import com.green.greenshare.note.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{
  private final MessageMapper messageMapper;


  @Override
  public int insertNote(MessageDTO messageDTO) {
    return messageMapper.insertNote(messageDTO);
  }

  @Override
  public List<MessageDTO> selectReceivedNotes(String receiverEmail) {
    return messageMapper.selectReceivedNotes(receiverEmail);
  }
}
