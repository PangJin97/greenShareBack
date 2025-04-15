package com.green.greenshare.farmer.service;

import com.green.greenshare.farmer.dto.FarmerDTO;

import java.util.List;

public interface FarmerService {

  //조회
  public List<FarmerDTO> farmerList(FarmerDTO farmerDTO);

  //최대가 5개만 조회
  public List<FarmerDTO> mainFarmers();


  //상세 정보 조회 쿼리
  public FarmerDTO selectFarmer(int boardNum);

  //등록
  public int insertFarmers(FarmerDTO farmerDTO);

  //수정
  public int updateFarmers (FarmerDTO farmerDTO);

  //삭제
  public  int deleteFarmers(int boardNum);

  // 작성자 이메일 조회 (권한 체크용)
  public String selectWriterEmail(int boardNum);
}
