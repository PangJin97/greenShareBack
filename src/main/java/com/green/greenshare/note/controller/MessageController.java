package com.green.greenshare.note.controller;

import com.green.greenshare.jwt.JwtUtil;
import com.green.greenshare.note.dto.MessageDTO;
import com.green.greenshare.note.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;

@RequiredArgsConstructor
@Controller
public class MessageController {


  private final JwtUtil jwtUtil;
  private final SimpMessagingTemplate messagingTemplate;
  private final MessageService messageService;

  @MessageMapping("/message/send")
  public void sendMessage(MessageDTO message) {

    // ✅ 콘솔 로그 추가
    System.out.println("📥 쪽지 수신됨 - 보낸 사람: " + message.getSenderEmail() + ", 받는 사람: " + message.getReceiverEmail());

    messageService.insertNote(message);

    messagingTemplate.convertAndSendToUser(
            message.getReceiverEmail(),
            "/queue/messages",
            message
    );
  }
}
