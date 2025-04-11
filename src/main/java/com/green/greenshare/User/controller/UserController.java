package com.green.greenshare.user.controller;

import com.green.greenshare.user.dto.UserDTO;
import com.green.greenshare.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
  private  final UserService userService;

  //QNA 목록 조회
  @GetMapping("")
  public ResponseEntity<?> qnaList(UserDTO userDTO) {
    try {
      List<UserDTO> qnaList = userService.qnaList(userDTO);

      return ResponseEntity.status(HttpStatus.OK).body(qnaList);

    }
    catch (Exception e){
      e.printStackTrace();

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("목록 조회 중 서버 오류 발생");
    }
  }

  //QNA 상세보기
  @GetMapping("/{qnaNum}")
  public ResponseEntity<?>  selectQna(@PathVariable("qnaNum")int qnaNum){
    try {

      UserDTO selectQna = userService.selectQna(qnaNum);

      return ResponseEntity.status(HttpStatus.OK).body(selectQna);

    }
    catch (Exception e){
      e.printStackTrace();

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("상세 조회 중 오류 발생");
    }
  }

  //QNA 등록
  @PostMapping("")
  public ResponseEntity<?> insertQna(@RequestBody UserDTO userDTO){
    try {
      int insertQna = userService.insertQna(userDTO);

      return ResponseEntity.status(HttpStatus.OK).body(insertQna);
    }
    catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록 중 서버 오류 발생");
    }
  }

  //QNA 수정
  @PutMapping("/{qnaNum}")
  public ResponseEntity<?>  updateQna(@PathVariable("qnaNum") int qnaNum,@RequestBody UserDTO userDTO){
    try {
      userDTO.setQnaNum(qnaNum);
      int updateQna = userService.updateQna(userDTO);
      return ResponseEntity.status(HttpStatus.OK).body(updateQna);
    }catch (Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("수정 중 서버 오류 발생");
    }
  }

  //QNA 질문 삭제
  @DeleteMapping("/{qnaNum}")
  public  ResponseEntity<?>   deleteQna(@PathVariable("qnaNum") int qnaNum){
    try {
      int deleteQna = userService.deleteQna(qnaNum);
      return ResponseEntity.status(HttpStatus.OK).body(deleteQna);
    }catch (Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제 중 서버 오류 발생");
    }
  }


}