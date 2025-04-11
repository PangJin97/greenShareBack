package com.green.greenshare.user.controller;

import com.green.greenshare.user.dto.UserDTO;
import com.green.greenshare.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CreatedBy 최재훈
 * last-update : 2025.04.11
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
  private final UserService userService;
  private final PasswordEncoder passwordEncoder;

  //회원가입
  @PostMapping("/join")
  public  ResponseEntity<?> join(@RequestBody UserDTO userDTO){
    try {
      //비밀번호 암호화
      String encodedPw =  passwordEncoder.encode(userDTO.getUserPasswod());

      //암호화한 비번 dto에 저장
      userDTO.setUserPasswod(encodedPw);

      //회원가입 진행
      userService.insertUserList(userDTO);

      return ResponseEntity.status(HttpStatus.OK).build();
    }catch (Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입 중 서버 오류 발생");
    }
  }

}