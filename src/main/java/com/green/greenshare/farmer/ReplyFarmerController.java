package com.green.greenshare.farmer;

import com.green.greenshare.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/replyFarmers")
public class ReplyFarmerController {
  private final ReplyFarmerService replyFarmerService;
  private final JwtUtil jwtUtil;


  //댓글 조회
  @GetMapping("/{boardNum}")
  public ResponseEntity<?> selectReply(@PathVariable("boardNum") int boardNum) {
    try {
      List<ReplyFarmersDTO> selectReply = replyFarmerService.replySelect(boardNum);

      return ResponseEntity.status(HttpStatus.OK).body(selectReply);

    } catch (Exception e) {
      e.printStackTrace();

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("목록 조회 중 서버 오류 발생");
    }
  }

  //댓글 등록
  @PreAuthorize("hasAnyRole('ADMIN','FARMER')")
  @PostMapping("")
  public ResponseEntity<?> insertReply(
          @RequestBody ReplyFarmersDTO replyFarmersDTO,
          @RequestHeader("Authorization") String token) {
    try {
      String userEmail = jwtUtil.getUsername(token.split(" ")[1]);
      replyFarmersDTO.setUserEmail(userEmail);

      int insertReply = replyFarmerService.insertReply(replyFarmersDTO);

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
      int deleteReply = replyFarmerService.deleteReply(replyNum);
      return ResponseEntity.status(HttpStatus.OK).body(deleteReply);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제 중 서버 오류 발생");
    }
  }
}
