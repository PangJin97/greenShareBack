package com.green.greenshare.note.controller;

import com.green.greenshare.note.dto.MessageDTO;
import com.green.greenshare.note.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class MessageApiController {
  private final MessageService messageService;

  @GetMapping("")
  public ResponseEntity<?> getReceivedNotes(@RequestParam String receiverEmail){
      try {
        List<MessageDTO> notes = messageService.selectReceivedNotes(receiverEmail);
        return ResponseEntity.ok(notes);

      }catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("서버오류 발생");
      }
  }
}
