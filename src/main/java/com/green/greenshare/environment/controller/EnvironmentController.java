package com.green.greenshare.environment.controller;


import com.green.greenshare.environment.dto.EnvironmentDTO;
import com.green.greenshare.environment.service.EnvironmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/environment")
public class EnvironmentController {
  private final EnvironmentService environmentService;

  @GetMapping("")
  public ResponseEntity<?> environmentlist(EnvironmentDTO environmentDTO){

    try {
      List<EnvironmentDTO> envList = environmentService.environmentlist(environmentDTO);
      return ResponseEntity.status(HttpStatus.OK)
              .body(envList);

    }catch (Exception e){
      e.printStackTrace();

      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("환경 데이터 조회 중 서버 오류 발생");
    }
  }

  //최신 데이터 받아오는 controller
  @GetMapping("/latest")
  public  ResponseEntity<?> lastestData (){

    try {
      EnvironmentDTO latestData = environmentService.latestData();

      return ResponseEntity
              .status(HttpStatus.OK)
              .body(latestData);

    }catch (Exception e){

      e.printStackTrace();

      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("최신 데이터 조회 중 서버 오류 발생");
    }
  }


  //최근 시간 데이터 받아오는 controller
  @GetMapping("/latestHour")
  public ResponseEntity<?> lastestData12 (){

    try {
      List<EnvironmentDTO> latestHourData = environmentService.latestData12();

      return ResponseEntity.status(HttpStatus.OK).body(latestHourData);

    }catch (Exception e){

      e.printStackTrace();

      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("최신 시간에 따른 데이터 조회 중 오류발생");
    }
  }


}
