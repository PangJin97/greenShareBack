package com.green.greenshare.plant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {

  private final PlantMapper plantMapper;

  /*기본작물 조회*/
  @Override
  public List<PlantDTO> getCropStandards() {
    return plantMapper.getCropStandards();
  }

  /*작물 상세 조회*/
  @Override
  public PlantDTO getSelectCropList(String id) {
    return plantMapper.getSelectCropList(id);
  }
}
