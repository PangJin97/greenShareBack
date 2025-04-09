package com.green.greenshare.plant.controller;

import com.green.greenshare.plant.dto.PlantDTO;
import com.green.greenshare.plant.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plants")
@RequiredArgsConstructor
public class PlantController {

  private final PlantService plantService;

  //작물 조회
  @GetMapping("")
  public ResponseEntity<?> getCropStandards(){

    try {
      List<PlantDTO> list = plantService.getCropStandards();

      return ResponseEntity.status(HttpStatus.OK).body(list);
    }catch (Exception e){
      e.printStackTrace();

      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("작물 목록 조회 중 서버오류 발생");
    }
  }

  /*작물 상세 조회*/
  @GetMapping("/{id}")
  public ResponseEntity<?> getSelectCropList(@PathVariable("id")String id ){

    try {
      PlantDTO plant = plantService.getSelectCropList(id);

      return ResponseEntity.status(HttpStatus.OK).body(plant);

    }catch (Exception e){
      e.printStackTrace();

      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("작물 상세 조회 중 서버 오류 발생");
    }
  }




}
