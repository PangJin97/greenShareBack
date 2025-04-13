package com.green.greenshare.plantStory.controller;

import com.green.greenshare.plantStory.dto.PlantStoryReplyDTO;
import com.green.greenshare.plantStory.service.PlantStoryReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/plantReplies")
public class PlantStoryReplyController {
  private final PlantStoryReplyService plantStoryReplyService;

  /*댓글 등록*/
  @PostMapping("")
  public ResponseEntity<?> insertReply(@RequestBody PlantStoryReplyDTO plantStoryReplyDTO){
    try {
      int storyReply = plantStoryReplyService.insertReply(plantStoryReplyDTO);
      return ResponseEntity.status(HttpStatus.OK)
              .body(storyReply);
    }catch(Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("댓글 등록 중 서버오류가 발생");
    }
  }

  /*게시글 당 댓글 조회*/
  @GetMapping("/{boardNum}")
  public ResponseEntity<?>getReplies(@PathVariable("boardNum") int boardNum){

    try {
      List<PlantStoryReplyDTO> replyList = plantStoryReplyService.getReplies(boardNum);
      return ResponseEntity.status(HttpStatus.OK)
              .body(replyList);
    }catch(Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("댓글 목록 조회 중 서버 오류 발생");
    }
  }

  /*댓글 삭제*/
  @DeleteMapping("/{commentId}")
  public ResponseEntity<?>deleteReply(@PathVariable("commentId") int commentId){
    try {
      int deleteReply = plantStoryReplyService.deleteReply(commentId);
      return ResponseEntity.status(HttpStatus.OK)
              .body(deleteReply);
    }catch(Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("댓글 삭제 중 서버오류 발생!");
    }
  }
}
