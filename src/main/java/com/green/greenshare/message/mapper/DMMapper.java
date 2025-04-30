package com.green.greenshare.message.mapper;


import com.green.greenshare.message.DTO.DirectDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DMMapper {

  /*메세지 보내기 쿼리*/
void sendMessage(DirectDTO directDTO);

/* 쓰레드 아이디로 메세지 조회 쿼리 */
List<DirectDTO> getMessagesByThread(Long threadId);

List<DirectDTO> LastByThread(
    @Param("threadId") Long threadId,
    @Param("lastMessageId") Long lastMessageId,
    @Param("limit") int limit
);

}
