package com.green.greenshare.message.controller;

import com.green.greenshare.message.DTO.DirectDTO;
import com.green.greenshare.message.DTO.ThreadDTO;
import com.green.greenshare.message.mapper.DMMapper;
import com.green.greenshare.message.service.DirectService;
import com.green.greenshare.message.service.ThreadServiceImpl;
import com.green.greenshare.note.mapper.MessageMapper;
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
  private DMMapper dmMapper;

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

  @GetMapping("/more")
  public ResponseEntity<List<DirectDTO>> loadMoreMessages(
      @RequestParam("sender") String sender,
      @RequestParam("receiver") String receiver,
      @RequestParam(value = "lastMessageId", required = false) Long lastMessageId,
      @RequestParam(value = "limit", defaultValue = "20") int limit
  ) {
    System.out.println("ㅇㅇㅇ");

    // 1. 쓰레드 ID 찾기
    ThreadDTO threadDTO = new ThreadDTO();
    threadDTO.setSender(sender);
    threadDTO.setReceiver(receiver);

    Long threadId = threadService.findThread(threadDTO);

    // 2. 쓰레드 ID로 메시지 조회
    List<DirectDTO> messages = dmMapper.LastByThread(threadId, lastMessageId, limit);

    return ResponseEntity.ok(messages);
  }
}
