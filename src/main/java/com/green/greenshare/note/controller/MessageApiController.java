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

  /*로그인 했을때 본인의 이메일을 토큰 해석하여 쿼리 빈값에 #{receiverEmail}넣어 본인의 쪽지함 목록 조회*/
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

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteNote(@PathVariable("id") int id){
    try{
      int deleteMessage = messageService.deleteNote(id);
      return ResponseEntity.status(HttpStatus.OK)
              .body(deleteMessage);
    }catch(Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("쪽지 삭제 중 서버 오류");

    }
  }
}
