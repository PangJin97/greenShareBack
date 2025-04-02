package com.green.greenshare.farmer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/replyFarmers")
public class ReplyFarmerController {
  private final ReplyFarmerService replyFarmerService;


  //댓글 조회
  @GetMapping("/{boardNum}")
  public List<ReplyFarmersDTO> selectReply(@PathVariable ("boardNum") int boardNum){
    return replyFarmerService.replySelect(boardNum);
  }

  //댓글 등록
  @PostMapping("")
  public void insertReply(@RequestBody ReplyFarmersDTO replyFarmersDTO){
    replyFarmerService.insertReply(replyFarmersDTO);
  }

  //댓글 삭제
  @DeleteMapping("/{replyNum}")
  public void deleteReply(@PathVariable ("replyNum") int replyNum){
    replyFarmerService.deleteReply(replyNum);
  }
}
