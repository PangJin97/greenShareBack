package com.green.greenshare.User.controller;

import com.green.greenshare.User.dto.UserDTO;
import com.green.greenshare.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
  private final UserService userService;
  private final PasswordEncoder passwordEncoder;




  @PostMapping("/user")
  public ResponseEntity<?> insertUserList(@RequestBody UserDTO userDTO) {
    try {
      // 비밀번호 암호화
      String encodedPw = passwordEncoder.encode(userDTO.getUserPassword());
      userDTO.setUserPassword(encodedPw);

      // 회원 등록 처리
      int regUser = userService.insertUserList(userDTO);

      return ResponseEntity.status(HttpStatus.OK).body(regUser);

    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("유저 등록 중 서버 오류 발생");
    }
  }

  // 로그인
  @PostMapping("/login")
  public ResponseEntity<?> getUserForLogin(@RequestParam String userEmail) {
    UserDTO user = userService.getUserForLogin(userEmail);

    if (user != null) {
      return ResponseEntity.ok(user);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("해당 유저 정보를 찾을 수 없습니다.");
    }
  }


}
