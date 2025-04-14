package com.green.greenshare.plantStory.controller;

import com.green.greenshare.jwt.JwtUtil;
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
  public ResponseEntity<?> insertPlantStory(
          @RequestBody PlantStoryDTO plantStoryDTO,
          @RequestHeader("Authorization") String token
  ) {
    try {
      String userEmail = jwtUtil.getUsername(token.split(" ")[1]);
      plantStoryDTO.setUserEmail(userEmail);

      int plantStory = plantStoryService.insertPlantStory(plantStoryDTO);
      return ResponseEntity.status(HttpStatus.OK).body(plantStory);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("식물 이야기 글 등록 중 서버오류");
    }
  }

  /*식물이야기 조회하기*/
  @GetMapping("")
  public ResponseEntity<?> getPlantStory() {
    try {
      List<PlantStoryDTO> getStory = plantStoryService.getPlantStory();
      return ResponseEntity.status(HttpStatus.OK).body(getStory);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("식물 이야기 조회 중 서버 오류 발생");
    }
  }

  /*식물 이야기 상세 조회*/
  @GetMapping("/{boardNum}")
  public ResponseEntity<?> detailPlantStory(@PathVariable("boardNum") int boardNum) {
    try {
      PlantStoryDTO detailStory = plantStoryService.detailPlantStory(boardNum);
      return ResponseEntity.status(HttpStatus.OK).body(detailStory);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("상세 조회 중 서버 오류 발생");
    }
  }

  /*식물 이야기 삭제*/
  @DeleteMapping("/{boardNum}")
  public ResponseEntity<?> deletePlantStory(
          @PathVariable("boardNum") int boardNum,
          @RequestHeader("Authorization") String token
  ) {
    try {
      String userEmail = jwtUtil.getUsername(token.split(" ")[1]);
      String role = jwtUtil.getRole(token.split(" ")[1]);
      String writerEmail = plantStoryService.getWriterEmail(boardNum);

      if (!userEmail.equals(writerEmail) && !"ROLE_ADMIN".equals(role)) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("삭제 권한이 없습니다.");
      }

      int deleteStory = plantStoryService.deletePlantStory(boardNum);
      return ResponseEntity.status(HttpStatus.OK).body(deleteStory);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("게시글 삭제 중 서버 오류 발생");
    }
  }

  /*식물이야기 수정*/
  @PutMapping("/{boardNum}")
  public ResponseEntity<?> updatePlantStory(
          @PathVariable("boardNum") int boardNum,
          @RequestBody PlantStoryDTO plantStoryDTO,
          @RequestHeader("Authorization") String token
  ) {
    try {
      String userEmail = jwtUtil.getUsername(token.split(" ")[1]);
      String role = jwtUtil.getRole(token.split(" ")[1]);
      String writerEmail = plantStoryService.getWriterEmail(boardNum);

      if (!userEmail.equals(writerEmail) && !"ROLE_ADMIN".equals(role)) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("수정 권한이 없습니다.");
      }

      plantStoryDTO.setBoardNum(boardNum);
      plantStoryDTO.setUserEmail(userEmail);

      int updateStory = plantStoryService.updatePlantStory(plantStoryDTO);
      return ResponseEntity.status(HttpStatus.OK).body(updateStory);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("이야기 수정 중 서버 오류 발생");
    }
  }
}
