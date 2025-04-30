package com.green.greenshare.message.mapper;

import com.green.greenshare.message.DTO.ThreadDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ThreadMapper {

  /*찾거나 쓰레드를 생성하는 쿼리*/
  Long findThread(ThreadDTO threadDTO);

  /*쓰레드  생성 쿼리*/
  void createThread(ThreadDTO threadDTO);

  /* 쓰레드 조회 쿼리 */
  ThreadDTO getThreadById(Long threadId);

}
