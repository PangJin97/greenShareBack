package com.green.greenshare.environment.controller;


import com.green.greenshare.environment.dto.EnvironmentDTO;
import com.green.greenshare.environment.service.EnvironmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/environment")
public class EnvironmentController {
  private final EnvironmentService environmentService;

  /*가장 최근 데이터 받아오는 api*/
  /*localhost:8080/api/environment/latest*/
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

  /*시간 간격으로 온도값을 받아오는 api*/
  /*localhost:8080/api/environment/temp*/
  @GetMapping("/temp")
  public ResponseEntity<?> getTemperatureByInterval(@RequestParam Map<String, String> params) {
    String interval = params.get("interval");
    try {
      List<EnvironmentDTO> byInterval = environmentService.selectTemperatureByInterval(interval);
      return ResponseEntity.status(HttpStatus.OK).body(byInterval);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("최신 시간에 따른 데이터 조회 중 오류발생");
    }
  }


  /*시간 간격으로 조도값을 받아오는 api*/
  /*localhost:8080/api/environment/lux*/
  @GetMapping("/lux")
  public ResponseEntity<?> getIlluminanceByInterval(@RequestParam Map<String, String> params) {
    String interval = params.get("interval");

    try {
      List<EnvironmentDTO> byInterval =  environmentService.selectIlluminanceByInterval(interval);

      return ResponseEntity.status(HttpStatus.OK).body(byInterval);

    }catch (Exception e){

      e.printStackTrace();

      return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("최신 시간에 따른 데이터 조회 중 오류발생");
    }

  }


  /*시간 간격으로 토양수분값을 받아오는 api*/
  /*localhost:8080/api/environment/soil*/
  /*어드민만 볼 수 있게*/
  @GetMapping("/soil")
  public ResponseEntity<?> getSoilByInterval(@RequestParam Map<String, String> params) {
    String interval = params.get("interval");

    try {
      List<EnvironmentDTO> byInterval =  environmentService.selectSoilByInterval(interval);

      return ResponseEntity.status(HttpStatus.OK).body(byInterval);

    }catch (Exception e){

      e.printStackTrace();

      return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("최신 시간에 따른 데이터 조회 중 오류발생");
    }
  }

  /*시간 간격으로 습도값을 받아오는 api*/
  /*localhost:8080/api/environment/humid*/

  @GetMapping("/humid")
  public ResponseEntity<?> getHumidByInterval(@RequestParam Map<String, String> params) {
    String interval = params.get("interval");

    try {
      List<EnvironmentDTO> byInterval =  environmentService.selectHumidityByInterval(interval);

      return ResponseEntity.status(HttpStatus.OK).body(byInterval);

    }catch (Exception e){

      e.printStackTrace();

      return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("최신 시간에 따른 데이터 조회 중 오류발생");
    }
  }
}
