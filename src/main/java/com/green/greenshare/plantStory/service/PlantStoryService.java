package com.green.greenshare.plantStory.service;

import com.green.greenshare.plantStory.dto.PlantStoryDTO;

import java.util.List;

public interface PlantStoryService {

  // 식물 이야기 등록
  public int insertPlantStory(PlantStoryDTO plantStoryDTO);

  // 전체 목록 조회
  public List<PlantStoryDTO> getPlantStory();

  // 상세 조회
  public PlantStoryDTO detailPlantStory(int boardNum);

  // 삭제
  public int deletePlantStory(int boardNum);

  // 수정
  public int updatePlantStory(PlantStoryDTO plantStoryDTO);

  // 작성자 이메일 조회 (권한 체크용)
  public String getWriterEmail(int boardNum);
}