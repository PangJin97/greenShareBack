package com.green.greenshare.note.controller;

import com.green.greenshare.jwt.JwtUtil;
import com.green.greenshare.note.dto.MessageDTO;
import com.green.greenshare.note.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class MessageApiController {
  private final JwtUtil jwtUtil;
  private final MessageService messageService;

  @GetMapping("")
  public ResponseEntity<?> getReceivedNotes(@RequestHeader("Authorization") String token){
      try {

        String userEmail = jwtUtil.getUsername(token.split(" ")[1]);


        List<MessageDTO> notes = messageService.selectReceivedNotes(userEmail);
        return ResponseEntity.status(HttpStatus.OK)
                .body(notes);

      }catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("서버오류 발생");
      }
  }
}
