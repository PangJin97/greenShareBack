package com.green.greenshare.message.service;

import com.green.greenshare.message.DTO.DirectDTO;
import com.green.greenshare.message.DTO.ThreadDTO;
import com.green.greenshare.message.mapper.DMMapper;
import com.green.greenshare.message.mapper.ThreadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectServiceImpl implements DirectService{

  @Autowired
  private DMMapper dmMapper;

  @Autowired
  private ThreadServiceImpl threadService;


  @Override /* 메세지 전송 기능 */
  public void sendMessage(DirectDTO directDTO) {
    Long threadId = directDTO.getThreadId() ; /*쓰레드의 아이디 값을 받기 위한 쓰레드DTO */
    threadService.getThreadById(threadId); /* 쓰레드 조회 */

    dmMapper.sendMessage(directDTO);/* 메세지 저장  */
  }

  @Override /* 메세지 조회 기능 */
  public List<DirectDTO> getMessagesByThread(Long threadId) {
    return dmMapper.getMessagesByThread(threadId);
  }
}

