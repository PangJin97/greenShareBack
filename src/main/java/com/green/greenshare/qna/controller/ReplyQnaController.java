package com.green.greenshare.qna.controller;

import com.green.greenshare.jwt.JwtUtil;
import com.green.greenshare.qna.dto.ReplyQnaDTO;
import com.green.greenshare.qna.service.ReplyQnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("replyQna")
public class ReplyQnaController {
  private final ReplyQnaService replyQnaService;
  private final JwtUtil jwtUtil;

  // qna 질문(댓글) 조회
  @GetMapping("/{boardNum}")
  public ResponseEntity<?> replySelect(@PathVariable("boardNum") int boardNum) {
    try {
      List<ReplyQnaDTO> replySelect = replyQnaService.replySelect(boardNum);

      return ResponseEntity.status(HttpStatus.OK).body(replySelect);

    } catch (Exception e) {
      e.printStackTrace();

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("목록 조회 중 서버 오류 발생");
    }
  }

  //qna 댓글 등록
  @PreAuthorize("hasAnyRole('ADMIN','FARMER')")
  @PostMapping("")
  public ResponseEntity<?> insertReply(
          @RequestBody ReplyQnaDTO ReplyQnaDTO,
          @RequestHeader("Authorization") String token) {
    try {
      String userEmail = jwtUtil.getUsername(token.split(" ")[1]);
      ReplyQnaDTO.setUserEmail(userEmail);


      int insertReply = replyQnaService.insertReply(ReplyQnaDTO);

      return ResponseEntity.status(HttpStatus.OK).body(insertReply);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록 중 서버 오류 발생");
    }
  }

  //댓글 삭제
  @PreAuthorize("hasAnyRole('ADMIN','FARMER')")
  @DeleteMapping("/{replyNum}")
  public ResponseEntity<?> deleteReply(@PathVariable("replyNum") int replyNum) {
    try {
      int deleteReply = replyQnaService.deleteReply(replyNum);
      return ResponseEntity.status(HttpStatus.OK).body(deleteReply);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제 중 서버 오류 발생");
    }
  }

}
