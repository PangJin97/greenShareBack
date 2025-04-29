package com.green.greenshare.message.controller;

import com.green.greenshare.message.DTO.DirectDTO;
import com.green.greenshare.message.DTO.ThreadDTO;
import com.green.greenshare.message.service.DirectService;
import com.green.greenshare.message.service.ThreadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class DMCotroller {

  @Autowired
  private DirectService directService;

  @Autowired
  private ThreadServiceImpl threadService;

  @PostMapping("/send") /* 메세지 전송 */
  public ResponseEntity<Void> sendMessage(@RequestBody DirectDTO directDTO) {
    directService.sendMessage(directDTO);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{threadId}") /*메세지 조회*/
  public ResponseEntity<List<DirectDTO>> getMessages(@PathVariable Long threadId) {
    List<DirectDTO> directDTOs = directService.getMessagesByThread(threadId);
    return ResponseEntity.ok(directDTOs);
  }

  @GetMapping("/threadFind") /*쓰레드 ID 찾기*/
  public ResponseEntity<Long> findThread(ThreadDTO threadDTO) {
    Long threadId = threadService.findThread(threadDTO);
    return ResponseEntity.ok(threadId);
  }


  /* 유저로 쓰레드 아이디 조회해 메세지 리스트 받아오는 api */
  @GetMapping("/messages")
  public ResponseEntity<List<DirectDTO>> getMessagesByUser(ThreadDTO threadDTO) {
    Long threadId = threadService.findThread(threadDTO); // 센더와 리시버로 쓰레드 ID 찾기

    List<DirectDTO> directDTOS = directService.getMessagesByThread(threadId); // 쓰레드 아이디로 메세지 조회

    return ResponseEntity.ok(directDTOS); // 조회한 데이터를 리턴
  }
}
