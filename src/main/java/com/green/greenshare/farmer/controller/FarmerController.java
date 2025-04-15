package com.green.greenshare.farmer.controller;

import com.green.greenshare.farmer.dto.FarmerDTO;
import com.green.greenshare.farmer.service.FarmerService;
import com.green.greenshare.jwt.JwtUtil;
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
  private final JwtUtil jwtUtil;


  @GetMapping("")
  public ResponseEntity<?> farmerList(@RequestHeader(name = "Authorization", required = false) String token,
                                      FarmerDTO farmerDTO) {
    try {
      String userEmail = null;

      // 토큰이 null이 아니고 "Bearer "로 시작하면 처리
      if (token != null && token.startsWith("Bearer ")) {
        String realToken = token.split(" ")[1];

        // 만료되지 않은 경우에만 이메일 추출
        if (!jwtUtil.isExpired(realToken)) {
          userEmail = jwtUtil.getUsername(realToken);
        }
      }

      farmerDTO.setUserEmail(userEmail);
      List<FarmerDTO> farmers = farmerService.farmerList(farmerDTO);
      return ResponseEntity.status(HttpStatus.OK).body(farmers);

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

  //상세조회
  @GetMapping("/{boardNum}")
  public ResponseEntity<?> selectFarmer(@PathVariable("boardNum") int boardNum) {
    try {
      FarmerDTO findFarmer = farmerService.selectFarmer(boardNum);
      return ResponseEntity.status(HttpStatus.OK).body(findFarmer);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("상세 조회 중 오류 발생");
    }
  }


  //등록
  @PostMapping("")
  public ResponseEntity<?> insertFarmers(
          @RequestBody FarmerDTO farmerDTO,
          @RequestHeader("Authorization") String token
  ) {
    try {
      String userEmail = jwtUtil.getUsername(token.split(" ")[1]);
      String role = jwtUtil.getRole(token.split(" ")[1]);  // role 정보를 가져온다고 가정

      if (role == null || (!role.equals("ADMIN") && !role.equals("USER"))) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("권한이 없습니다.");
      }

      int putFarmers = farmerService.insertFarmers(farmerDTO);
      return ResponseEntity.status(HttpStatus.OK).body(putFarmers);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록 중 서버 오류 발생");
    }
  }



  //수정
  @PutMapping("/{boardNum}")
  public ResponseEntity<?> updateFarmers(
          @PathVariable("boardNum") int boardNum,
          @RequestBody FarmerDTO farmerDTO,
          @RequestHeader("Authorization") String token
  ) {
    try {
      String userEmail = jwtUtil.getUsername(token.split(" ")[1]);

      String writerEmail = farmerService.selectWriterEmail(boardNum);
      // 작성자 이메일과 현재 사용자가 일치하는지 확인
      if (!userEmail.equals(writerEmail)) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("자신의 게시글만 수정 가능합니다.");
      }

      farmerDTO.setBoardNum(boardNum);

      int updateResult = farmerService.updateFarmers(farmerDTO);
      return ResponseEntity.status(HttpStatus.OK).body(updateResult);

    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("수정 중 서버 오류 발생");
    }
  }

  @DeleteMapping("/{boardNum}")
  public ResponseEntity<?> deleteFarmers(@PathVariable("boardNum") int boardNum,
                                         @RequestHeader("Authorization") String token) {

    try {
      // 인증된 사용자 이메일 추출
      String userEmail = jwtUtil.getUsername(token.split(" ")[1]);

      // 게시글의 작성자 이메일을 가져옴
      String writerEmail = farmerService.selectWriterEmail(boardNum);

      // 작성자 이메일과 현재 사용자가 일치하는지 확인
      if (!userEmail.equals(writerEmail)) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("자신의 게시글만 삭제 가능합니다.");
      }

      // 게시글 삭제
      int deleteResult = farmerService.deleteFarmers(boardNum);
      return ResponseEntity.status(HttpStatus.OK).body(deleteResult);

    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제 중 서버 오류 발생");
    }
  }

}
