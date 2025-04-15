package com.green.greenshare.follow.controller;


import com.green.greenshare.follow.service.FollowService;
import com.green.greenshare.follow.dto.FollowDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("follow")
@RequiredArgsConstructor
public class FollowController {
  private final FollowService followService;

  //팔로우 쿼리
  @PostMapping("/insert")
  public int insertFollow(@RequestBody FollowDTO followDTO) {
    return followService.insertFollow(followDTO);
  }



  //내가 팔로우한 목록조회
  @GetMapping("")
  public List<FollowDTO> selectFollowingList(@RequestParam("fromUserEmail")String fromUserEmail){
    return followService.selectFollowingList(fromUserEmail);
  }


  @DeleteMapping("/unfollow")
  public int unfollow(@RequestParam("fromUserEmail") String fromUserEmail,
                      @RequestParam("toUserEmail") String toUserEmail) {
    return followService.unfollow(fromUserEmail, toUserEmail);
  }




}
