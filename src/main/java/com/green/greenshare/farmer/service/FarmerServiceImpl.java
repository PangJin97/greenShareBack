package com.green.greenshare.farmer.service;

import com.green.greenshare.farmer.dto.FarmerDTO;
import com.green.greenshare.farmer.mapper.FarmerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FarmerServiceImpl implements FarmerService{
  private final FarmerMapper farmerMapper;

  //조회
  @Override
  public List<FarmerDTO> farmerList(FarmerDTO farmerDTO) {
    return farmerMapper.farmerList(farmerDTO);
  }

  //5개까지 조회
  @Override
  public List<FarmerDTO> mainFarmers() {
    return farmerMapper.mainFarmers();
  }

  //상세조회
  @Override
  public FarmerDTO selectFarmer(int boardNum) {
    //조회수 증가
    farmerMapper.updateViews(boardNum);
    //상세 조회
    return farmerMapper.selectFarmer(boardNum);
  }

  //등록
  @Override
  public int insertFarmers(FarmerDTO farmerDTO) {
    return farmerMapper.insertFarmers(farmerDTO);
  }

  //수정
  @Override
  public int updateFarmers(FarmerDTO farmerDTO) {
    return farmerMapper.updateFarmers(farmerDTO);
  }

  //삭제
  @Override
  public int deleteFarmers(int boardNum) {
    return farmerMapper.deleteFarmers(boardNum);
  }

  // 작성자 이메일 조회 (권한 체크용)
  @Override
  public String selectWriterEmail(int boardNum) {
    return farmerMapper.selectWriterEmail(boardNum);
  }


}

