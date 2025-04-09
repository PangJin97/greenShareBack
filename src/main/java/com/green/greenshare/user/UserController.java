package com.green.greenshare.user;

import com.green.greenshare.farmer.FarmerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
  private  final UserService userService;

  //QNA 목록 조회
  @GetMapping("")
  public List<UserDTO> qnaList(UserDTO userDTO) {
    return  userService.qnaList(userDTO);
  }

  //QNA 상세보기
  @GetMapping("/{qnaNum}")
  public UserDTO selectQna(@PathVariable("qnaNum")int qnaNum){
    return userService.selectQna(qnaNum);
  }

  //QNA 등록
  @PostMapping("")
  public int insertQna(@RequestBody UserDTO userDTO){
    return userService.insertQna(userDTO);
  }

  //QNA 수정
  @PutMapping("/{qnaNum}")
  public int updateQna(@PathVariable("qnaNum") int qnaNum,@RequestBody UserDTO userDTO){
    userDTO.setQnaNum(qnaNum);
    return userService.updateQna(userDTO);
  }

  //QNA 질문 삭제
  @DeleteMapping("/{qnaNum}")
  public  int  deleteQna(@PathVariable("qnaNum") int qnaNum){
    return userService.deleteQna(qnaNum);
  }
}
