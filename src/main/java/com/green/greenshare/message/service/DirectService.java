package com.green.greenshare.message.service;

import com.green.greenshare.message.DTO.DirectDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DirectService {


  /*메세지 보내기 쿼리*/
  void sendMessage(DirectDTO directDTO);

  /* 쓰레드 아이디로 메세지 조회 쿼리 */
  List<DirectDTO> getMessagesByThread(Long threadId);
}
