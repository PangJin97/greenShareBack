package com.green.greenshare.note.controller;

import com.green.greenshare.message.DTO.DirectDTO;
import com.green.greenshare.message.service.DirectService;
import com.green.greenshare.note.dto.MessageDTO;
import com.green.greenshare.note.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MessageStompController {

  private final SimpMessagingTemplate messagingTemplate;
  private final MessageService messageService; // ✅ DB 저장용 서비스 주입
  private final DirectService directService;

  /**
   * WebSocket으로 /app/note/send 경로로 쪽지를 받으면 처리
   */
  @MessageMapping("/note/send")
  public void sendNote(MessageDTO messageDTO) {
    log.info("💬 WebSocket 쪽지 수신: {}", messageDTO);

    // 1. DB에 쪽지 저장
    messageService.insertNote(messageDTO);

    // 2. 수신자에게 실시간으로 쪽지 전송
    messagingTemplate.convertAndSendToUser(
        messageDTO.getReceiverEmail(), // 수신자 이메일
        "/queue/notes",                 // 수신자가 구독하고 있는 Queue
        messageDTO                      // 전송할 메시지 데이터
    );
  }


  @MessageMapping("/sendMessage")
  @SendToUser("/queue/ack") // 사용자 개인 큐에 응답
  public DirectDTO sendMessage(DirectDTO directDTO) {
    directService.sendMessage(directDTO); // DB 저장 등 처리
    messagingTemplate.convertAndSend("/topic/messages", directDTO); // 브로드캐스트
    return directDTO; // 클라이언트에게 응답 (예: 메시지 전송 성공 알림)
  }

}
