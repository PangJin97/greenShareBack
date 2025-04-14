package com.green.greenshare.plantStory.controller;

import com.green.greenshare.jwt.JwtUtil;
import com.green.greenshare.plantStory.dto.LikeDTO;
import com.green.greenshare.plantStory.dto.PlantStoryDTO;
import com.green.greenshare.plantStory.service.PlantStoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/plantStories")
public class PlantStoryController {
  private final PlantStoryService plantStoryService;
  private final JwtUtil jwtUtil;

  /*식물이야기 등록하기*/
  @PostMapping("")
  public ResponseEntity<?> insertPlantStory(@RequestBody PlantStoryDTO plantStoryDTO){
    try {
      int plantStory = plantStoryService.insertPlantStory(plantStoryDTO);
      return ResponseEntity.status(HttpStatus.OK)
              .body(plantStory);
    }catch(Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("식물 이야기 글 등록 중 서버오류");
    }
  }

  /*식물이야기 조회하기*/
  @GetMapping("")
  public ResponseEntity<?> getPlantStory(@RequestHeader(name = "Authorization", required = false) String token){
    try {

      System.out.println(token);
      //토큰이 null이 아닐때만 로그인 유저 정보 세팅
      String userEmail = null;
      if(token != null && !jwtUtil.isExpired(token.split(" ")[1])){

        String loginUserEmail = jwtUtil.getUsername(token.split(" ")[1]);
        userEmail = loginUserEmail;
      }


      List<PlantStoryDTO> getStory = plantStoryService.getPlantStory(userEmail);
      return ResponseEntity.status(HttpStatus.OK)
              .body(getStory);
    }catch(Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("식물 이야기 조회 중 서버 오류 발생");
    }
  }

  /*식물 이야기 상세 조회*/
  @GetMapping("/{boardNum}")
  public ResponseEntity<?> detailPlantStory(@PathVariable("boardNum") int boardNum){
    try {
      PlantStoryDTO detailStory = plantStoryService.detailPlantStory(boardNum);
      return ResponseEntity.status(HttpStatus.OK)
              .body(detailStory);
    }catch(Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("상세 조회 중 서버 오류 발생");
    }
  }

  /*식물 이야기 삭제*/
  @DeleteMapping("/{boardNum}")
  public ResponseEntity<?> deletePlantStory(@PathVariable("boardNum") int boardNum){
    try {
      int deleteStory = plantStoryService.deletePlantStory(boardNum);
      return ResponseEntity.status(HttpStatus.OK)
              .body(deleteStory);
    }catch(Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("게시글 삭제중 서버 오류 발생");
    }
  }

  /*식물이야기 수정*/
  @PutMapping("/{boardNum}")
  public ResponseEntity<?>updatePlantStory(@PathVariable("boardNum") int boardNum, @RequestBody PlantStoryDTO plantStoryDTO){
    try {
      plantStoryDTO.setBoardNum(boardNum);
      int updateStory = plantStoryService.updatePlantStory(plantStoryDTO);
      return ResponseEntity.status(HttpStatus.OK)
              .body(updateStory);
    }catch(Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("이야기 수정 중 서버오류 발생");
    }
  }

  //좋아요 선택
  @PostMapping("/like-insert")
  public ResponseEntity<?> insertLike(
          @RequestBody LikeDTO likeDTO, //이 곳에서 boardNum 가져옴
          @RequestHeader("Authorization") String token //로그인한 회원의 토큰
  ){

    //토큰에서 회원 아이디만 추출 후 DTO에 저장
    String loginUserEmail = jwtUtil.getUsername(token.split(" ")[1]);
    likeDTO.setUserEmail(loginUserEmail);

    //LIKE 정보 INSERT 쿼리 실행
    plantStoryService.insertLike(likeDTO);
    return ResponseEntity.status(HttpStatus.CREATED).build();

  }

  //좋아요 해제
  @DeleteMapping("/like-delete/{boardNum}")
  public ResponseEntity<?> deleteLike(
          @PathVariable("boardNum") int boardNum,
          @RequestHeader("Authorization") String token //로그인한 회원의 토큰
  ){
    //토큰이 null이 아닐때만 로그인 유저 정보 세팅
    String userEmail = null;
    if(token != null && !jwtUtil.isExpired(token.split(" ")[1])){

      String loginUserEmail = jwtUtil.getUsername(token.split(" ")[1]);
      userEmail = loginUserEmail;
    }

    LikeDTO likeDTO = new LikeDTO();
    likeDTO.setBoardNum(boardNum);
    likeDTO.setUserEmail(userEmail);

    plantStoryService.deleteLike(likeDTO);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
