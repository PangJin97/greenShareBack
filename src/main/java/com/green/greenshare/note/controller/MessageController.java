package com.green.greenshare.note.controller;

import com.green.greenshare.note.dto.MessageDTO;
import com.green.greenshare.note.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class MessageController {

  private final SimpMessagingTemplate messagingTemplate;
  private final MessageService messageService;

  @MessageMapping("/message/send")
  public void sendMessage(MessageDTO message) {

    messageService.insertNote(message);

    messagingTemplate.convertAndSendToUser(
            message.getReceiverEmail(),
            "/queue/messages",
            message
    );
  }
}
