package com.green.greenshare.message.DTO;

import com.green.greenshare.user.dto.UserDTO;
import lombok.Data;

@Data
public class DirectDTO {  /* 쓰레드 DTO */
  private Long threadId;        // 메시지가 속한 스레드 ID
  private String sender;        // 보낸 사람
  private String receiver;      // 받는 사람
  private String content;       // 메시지 내용
  private String timestamp;     // 메시지 전송 시간


}
