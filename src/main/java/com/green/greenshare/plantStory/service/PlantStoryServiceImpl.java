package com.green.greenshare.plantStory.service;

import com.green.greenshare.plantStory.dto.LikeDTO;
import com.green.greenshare.plantStory.dto.PlantStoryDTO;
import com.green.greenshare.plantStory.mapper.PlantStoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantStoryServiceImpl implements PlantStoryService {

  private final PlantStoryMapper plantStoryMapper;

  @Override
  public int insertPlantStory(PlantStoryDTO plantStoryDTO) {
    return plantStoryMapper.insertPlantStory(plantStoryDTO);
  }

  @Override
  public List<PlantStoryDTO> getPlantStory(String userEmail) {
    return plantStoryMapper.getPlantStory(userEmail);
  }

  @Override
  public PlantStoryDTO detailPlantStory(int boardNum) {
    plantStoryMapper.updateCnt(boardNum);
    return plantStoryMapper.detailPlantStory(boardNum);
  }

  @Override
  public int deletePlantStory(int boardNum) {
    return plantStoryMapper.deletePlantStory(boardNum);
  }

  @Override
  public int updatePlantStory(PlantStoryDTO plantStoryDTO) {
    return plantStoryMapper.updatePlantStory(plantStoryDTO);
  }


  //좋아요 선택
  @Override
  public void insertLike(LikeDTO likeDTO) {
    plantStoryMapper.insertLike(likeDTO);
  }

  //좋아요 해체
  @Override
  public void deleteLike(LikeDTO likeDTO) {
    plantStoryMapper.deleteLike(likeDTO);
  }

  @Override
  public String getWriterEmail(int boardNum) {
    return plantStoryMapper.getWriterEmail(boardNum);
  }

  @Override
  public List<PlantStoryDTO> selectBoard(PlantStoryDTO plantStoryDTO) {
    return plantStoryMapper.selectBoard(plantStoryDTO);
  }
}
