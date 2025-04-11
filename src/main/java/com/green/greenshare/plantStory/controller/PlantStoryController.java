package com.green.greenshare.plantStory.controller;

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
  public ResponseEntity<?> getPlantStory(){
    try {
      List<PlantStoryDTO> getStory = plantStoryService.getPlantStory();
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
}
