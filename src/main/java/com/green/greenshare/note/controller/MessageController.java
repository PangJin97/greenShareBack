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

import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class MessageController {


  private final JwtUtil jwtUtil;
  private final SimpMessagingTemplate messagingTemplate;
  private final MessageService messageService;

  @MessageMapping("/note/555")
  public void sendMessage(MessageDTO message) {
    System.out.println("👉 message: " + message);
    System.out.println("📨 receiver: " + message.getReceiverEmail());


    messageService.insertNote(message);

    messagingTemplate.convertAndSendToUser(
            message.getReceiverEmail(),
            "/queue/notes",
            message
    );
  }
}
