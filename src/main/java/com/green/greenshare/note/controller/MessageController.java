package com.green.greenshare.note.controller;

import com.green.greenshare.note.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class MessageController {

  private final SimpMessagingTemplate messagingTemplate;

  @MessageMapping("/message/send")
  public void sendMessage(MessageDTO message) {
    messagingTemplate.convertAndSendToUser(
            message.getReceiverEmail(),
            "/queue/messages",
            message
    );
  }
}
