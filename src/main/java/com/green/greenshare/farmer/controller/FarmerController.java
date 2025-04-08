package com.green.greenshare.farmer.controller;

import com.green.greenshare.farmer.dto.FarmerDTO;
import com.green.greenshare.farmer.service.FarmerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/farmers")
public class FarmerController {
  private final FarmerService farmerService;


  //목록 조회
  @GetMapping("")
  public ResponseEntity<?> farmerList(){

    try {
      List<FarmerDTO> farmers = farmerService.farmerList();

      return ResponseEntity.status(HttpStatus.OK).body(farmers);

    }catch (Exception e){
      e.printStackTrace();

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("목록 조회 중 서버 오류 발생");
    }
  }

  //상세조회
  @GetMapping("/{boardNum}")
  public ResponseEntity<?> selectFarmer(@PathVariable("boardNum") int boardNum) {

    try {

      FarmerDTO findFarmer = farmerService.selectFarmer(boardNum);

      return ResponseEntity.status(HttpStatus.OK).body(findFarmer);

    }catch (Exception e){
      e.printStackTrace();

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("상세 조회 중 오류 발생");
    }
  }

  //등록
  @PostMapping("")
  public ResponseEntity<?> insertFarmers(@RequestBody FarmerDTO farmerDTO){
    try {

      int putFarmers = farmerService.insertFarmers(farmerDTO);

      return ResponseEntity.status(HttpStatus.OK).body(putFarmers);

    }catch (Exception e){
       e.printStackTrace();
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록 중 서버 오류 발생");
    }
  }

  //수정
  @PutMapping("/{boardNum}")
  public ResponseEntity<?> updateFarmers(@PathVariable("boardNum") int boardNum,@RequestBody FarmerDTO farmerDTO){

    try {

      farmerDTO.setBoardNum(boardNum);
      int updateFarmer = farmerService.updateFarmers(farmerDTO);

      return ResponseEntity.status(HttpStatus.OK).body(updateFarmer);

    }catch (Exception e){
      e.printStackTrace();

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("수정 중 서버 오류 발생");

    }
  }

  //삭제
  @DeleteMapping("/{boardNum}")
  public ResponseEntity<?> deleteFarmers(@PathVariable("boardNum")int boardNum){

    try {

      int deleteFarmer = farmerService.deleteFarmers(boardNum);
      return ResponseEntity.status(HttpStatus.OK).body(deleteFarmer);

    }catch (Exception e){

      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제 중 서버 오류 발생");

    }
  }

}
