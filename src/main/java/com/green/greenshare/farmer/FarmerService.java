package com.green.greenshare.farmer;

import java.util.List;

public interface FarmerService {

  //조회
  public List<FarmerDTO> farmerList();

  //상세 정보 조회 쿼리
  public FarmerDTO selectFarmer(int boardNum);

  //등록
  public int insertFarmers(FarmerDTO farmerDTO);

  //수정
  public int updateFarmers (FarmerDTO farmerDTO);

  //삭제
  public  int deleteFarmers(int boardNum);


}
