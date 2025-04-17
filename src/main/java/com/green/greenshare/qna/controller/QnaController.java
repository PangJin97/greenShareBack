package com.green.greenshare.qna.controller;

import com.green.greenshare.farmer.dto.FarmerDTO;
import com.green.greenshare.jwt.JwtUtil;
import com.green.greenshare.qna.dto.QnaDTO;
import com.green.greenshare.qna.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qna")
public class QnaController {
  private  final QnaService qnaService;
  private final JwtUtil jwtUtil;

  //QNA 목록 조회
  @GetMapping("")
  public ResponseEntity<?> qnaList(QnaDTO qnaDTO) {
    try {
      List<QnaDTO> qnaList = qnaService.qnaList(qnaDTO);

      return ResponseEntity.status(HttpStatus.OK).body(qnaList);

    }
    catch (Exception e){
      e.printStackTrace();

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("목록 조회 중 서버 오류 발생");
    }
  }

  //최대가 5개만 조회
  @GetMapping("/qnaTest")
  public ResponseEntity<?> mainQna() {
    try {
      List<QnaDTO> mainFarmers = qnaService.mainQna();
      return ResponseEntity.status(HttpStatus.OK).body(mainFarmers);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("최신 게시물 조회 중 서버 오류 발생");
    }
  }


  //QNA 상세보기
  @GetMapping("/{qnaNum}")
  public ResponseEntity<?>  selectQna(@PathVariable("qnaNum") int qnaNum){
    try {

      QnaDTO selectQna = qnaService.selectQna(qnaNum);

      return ResponseEntity.status(HttpStatus.OK).body(selectQna);

    }
    catch (Exception e){
      e.printStackTrace();

      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("상세 조회 중 오류 발생");
    }
  }

  //QNA 등록
  @PreAuthorize("isAuthenticated()")
  @PostMapping("")
  public ResponseEntity<?> insertQna(
          @RequestBody QnaDTO qnaDTO,
          @RequestHeader("Authorization") String token){
    try {
      String userEmail = jwtUtil.getUsername(token.split(" ")[1]);
      qnaDTO.setUserEmail(userEmail);
      int insertQna = qnaService.insertQna(qnaDTO);

      return ResponseEntity.status(HttpStatus.OK).body(insertQna);
    }
    catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록 중 서버 오류 발생");
    }
  }

  //QNA 수정
  @PreAuthorize("isAuthenticated()")
  @PutMapping("/{qnaNum}")
  public ResponseEntity<?>  updateQna(@PathVariable("qnaNum") int qnaNum,@RequestBody QnaDTO qnaDTO){
    try {
      qnaDTO.setQnaNum(qnaNum);
      int updateQna = qnaService.updateQna(qnaDTO);
      return ResponseEntity.status(HttpStatus.OK).body(updateQna);
    }catch (Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("수정 중 서버 오류 발생");
    }
  }

  //QNA 질문 삭제
  @PreAuthorize("hasAnyRole('ADMIN,'USER')")
  @DeleteMapping("/{qnaNum}")
  public  ResponseEntity<?>  deleteQna(@PathVariable("qnaNum") int qnaNum){
    try {
      int deleteQna = qnaService.deleteQna(qnaNum);
      return ResponseEntity.status(HttpStatus.OK).body(deleteQna);
    }catch (Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제 중 서버 오류 발생");
    }
  }

}
