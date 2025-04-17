package com.green.greenshare.farmer.controller;

import com.green.greenshare.farmer.dto.FarmerDTO;
import com.green.greenshare.farmer.service.FarmerService;
import com.green.greenshare.jwt.JwtUtil;
import com.green.greenshare.plantStory.dto.PlantStoryDTO;
import com.green.greenshare.qna.dto.QnaDTO;
import lombok.RequiredArgsConstructor;
import org.apache.el.parser.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/farmers")
public class FarmerController {
  private final FarmerService farmerService;
  private final JwtUtil jwtUtil;


  @GetMapping("")
  public ResponseEntity<?> farmerList(FarmerDTO farmerDTO) {
    try {
      List<FarmerDTO> farmerList = farmerService.farmerList(farmerDTO);

      // ✅ farmerList 자체를 응답으로 보내야 함!
      return ResponseEntity.status(HttpStatus.OK).body(farmerList);

    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("목록 조회 중 서버 오류 발생");
    }
  }


  //최대가 5개만 조회
  @GetMapping("/latest")
  public ResponseEntity<?> mainFarmers() {
    try {
      List<FarmerDTO> mainFarmers = farmerService.mainFarmers();
      return ResponseEntity.status(HttpStatus.OK).body(mainFarmers);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("최신 게시물 조회 중 서버 오류 발생");
    }
  }


  //공지사항  상세보기
  @GetMapping("/{boardNum}")
  public ResponseEntity<?> selectFarmer(@PathVariable("boardNum") int boardNum) {
    try {
      FarmerDTO selectFarmer = farmerService.selectFarmer(boardNum);

      return ResponseEntity.status(HttpStatus.OK).body(selectFarmer);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("상세 조회 중 오류 발생");
    }
  }


  //공지사항 게시글 등록
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping("")
  public ResponseEntity<?> insertFarmer(
          @RequestBody FarmerDTO farmerDTO,
          @RequestHeader("Authorization") String token
  ) {
    try {
      String userEmail = jwtUtil.getUsername(token.split(" ")[1]);
      farmerDTO.setUserEmail(userEmail);


      int insertFarmers = farmerService.insertFarmers(farmerDTO);

      return ResponseEntity.status(HttpStatus.OK).body(insertFarmers);
    } catch (Exception e) {
      // 예외 발생 시 서버 오류 응답
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("농부 등록 중 서버 오류");
    }
  }


  //공지사항 수정
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping("/{boardNum}")
  public ResponseEntity<?>  updateFarmers(@PathVariable("boardNum") int boardNum,@RequestBody FarmerDTO farmerDTO){
    try {
      int updateFarmers = farmerService.updateFarmers(farmerDTO);
      return ResponseEntity.status(HttpStatus.OK).body(updateFarmers);
    }catch (Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("수정 중 서버 오류 발생");
    }
  }

  //공지사항 질문 삭제
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{boardNum}")
  public  ResponseEntity<?>  deleteFarmers(@PathVariable("boardNum") int boardNum){
    try {
      int deleteFarmers = farmerService.deleteFarmers(boardNum);
      return ResponseEntity.status(HttpStatus.OK).body(deleteFarmers);
    }catch (Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제 중 서버 오류 발생");
    }
  }

}
