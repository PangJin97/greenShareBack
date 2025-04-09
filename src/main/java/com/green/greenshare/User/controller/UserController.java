package com.green.greenshare.User.controller;

import com.green.greenshare.User.dto.UserDTO;
import com.green.greenshare.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  @PostMapping("")
  public ResponseEntity<?> insertUserList(@RequestBody UserDTO userDTO){

    try {

      int regUser = userService.insertUserList(userDTO);

      return ResponseEntity.status(HttpStatus.OK).body(regUser);

    }catch (Exception e){

      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("유저 등록 중 서버 오류 발생");

    }
  }
}
