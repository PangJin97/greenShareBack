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

 /*쪽지 송수신 */
  @Override
  public int insertNote(MessageDTO messageDTO) {
    return messageMapper.insertNote(messageDTO);
  }

  /*쪽지 목록 조회*/
  @Override
  public List<MessageDTO> selectReceivedNotes(String receiverEmail) {
    return messageMapper.selectReceivedNotes(receiverEmail);
  }

  /*쪽지 삭제*/
  @Override
  public int deleteNote(int id) {
    return messageMapper.deleteNote(id);
  }
}
