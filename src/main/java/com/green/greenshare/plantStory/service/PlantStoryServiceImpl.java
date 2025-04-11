package com.green.greenshare.plantStory.service;

import com.green.greenshare.plantStory.dto.PlantStoryDTO;
import com.green.greenshare.plantStory.mapper.PlantStoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantStoryServiceImpl implements PlantStoryService{

  private final PlantStoryMapper plantStoryMapper;

  /*식물 이야기 등록*/
  @Override
  public int insertPlantStory(PlantStoryDTO plantStoryDTO) {
    return plantStoryMapper.insertPlantStory(plantStoryDTO);
  }

  /*식물 이야기 조회*/
  @Override
  public List<PlantStoryDTO> getPlantStory() {
    return plantStoryMapper.getPlantStory();
  }

  /*식물 이야기 상세 조회, 조회수 증가*/
  @Override
  public PlantStoryDTO detailPlantStory(int boardNum) {

    //상세 조회하면 조회수도 증가
    plantStoryMapper.updateCnt(boardNum);

    return plantStoryMapper.detailPlantStory(boardNum);
  }
}
