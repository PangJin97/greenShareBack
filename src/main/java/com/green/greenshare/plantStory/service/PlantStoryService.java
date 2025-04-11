package com.green.greenshare.plantStory.service;

import com.green.greenshare.plantStory.dto.PlantStoryDTO;

import java.util.List;

public interface PlantStoryService {

  /*식물 이야기 등록하기*/
  public int insertPlantStory(PlantStoryDTO plantStoryDTO);

  /*식물 이야기 조회하기*/
  public List<PlantStoryDTO> getPlantStory();

  /*식물 이야기 상세조회*/
  public PlantStoryDTO detailPlantStory(int boardNum);
}
