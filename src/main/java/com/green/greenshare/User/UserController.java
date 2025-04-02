package com.green.greenshare.User;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  @PostMapping("")
  public void insertUserList(@RequestBody UserDTO userDTO){
    userService.insertUserList(userDTO);
  }



}
