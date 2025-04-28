package com.green.greenshare.note.controller;

import com.green.greenshare.note.dto.MessageDTO;
import com.green.greenshare.note.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class ChatController {

  private final MessageService messageService;

  private final SimpMessagingTemplate messagingTemplate;

  public ChatController(SimpMessagingTemplate messagingTemplate, MessageService messageService) {
    this.messageService = messageService;
    this.messagingTemplate = messagingTemplate;
  }

  @MessageMapping("/note/send")
  public void sendChat(MessageDTO message, Principal principal) {

    System.out.println("✅ principal name = " + (principal != null ? principal.getName() : "null"));
    System.out.println("✅ 수신자 이메일 = " + message.getReceiverEmail());

    messageService.insertNote(message);
    messagingTemplate.convertAndSendToUser(
            message.getReceiverEmail(),
            "/queue/notes",
            message
    );
  }
}
