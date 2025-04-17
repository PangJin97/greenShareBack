package com.green.greenshare.note.controller;

import com.green.greenshare.note.dto.MessageDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class ChatController {
  private final SimpMessagingTemplate messagingTemplate;

  public ChatController(SimpMessagingTemplate messagingTemplate) {
    this.messagingTemplate = messagingTemplate;
  }

  @MessageMapping("/note/send")
  @SendTo("/queue/notes")
  public void sendChat(MessageDTO message, Principal principal) {
    messagingTemplate.convertAndSendToUser(
            message.getReceiverEmail(),
            "/queue/notes",
            message
    );
  }
}
