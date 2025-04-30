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

 //앱에서 내가 쓴글만 조회하기
  @Override
  public List<PlantStoryDTO> selectMyPost(String userEmail) {
    return plantStoryMapper.selectMyPost(userEmail);
  }

  @Override
  public List<PlantStoryDTO> getPopularPosts() {
    return plantStoryMapper.getPopularPosts();
  }

  @Override
  public List<PlantStoryDTO> selectBoard(PlantStoryDTO plantStoryDTO) {
    return plantStoryMapper.selectBoard(plantStoryDTO);
  }
}
