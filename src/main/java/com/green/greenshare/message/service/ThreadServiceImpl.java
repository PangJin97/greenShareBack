package com.green.greenshare.message.service;

import com.green.greenshare.message.DTO.ThreadDTO;
import com.green.greenshare.message.mapper.ThreadMapper;
import com.green.greenshare.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadServiceImpl {

  @Autowired
  private ThreadMapper threadMapper;



  public Long findThread(ThreadDTO threadDTO){/*쓰레드 조회*/

    Long threadId = threadMapper.findThread(threadDTO); /*쓰레드가 존재하는지 유무 판단*/
    if (threadId == null) {
      threadMapper.createThread(threadDTO); // 없으면 생성
      threadId = threadMapper.findThread(threadDTO); // ✅ 다시 조회한 결과 저장
    }
    return threadId;
  }


  public ThreadDTO  getThreadById(Long threadId){/*채팅방 조회 쿼리*/

    return threadMapper.getThreadById(threadId);
  }


}
