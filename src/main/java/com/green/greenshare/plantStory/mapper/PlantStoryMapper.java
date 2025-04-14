package com.green.greenshare.plantStory.mapper;

import com.green.greenshare.plantStory.dto.LikeDTO;
import com.green.greenshare.plantStory.dto.PlantStoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlantStoryMapper {

  /*식물 이야기 등록하기*/
  public int insertPlantStory(PlantStoryDTO plantStoryDTO);

  /*식물 이야기 조회하기*/
  public List<PlantStoryDTO> getPlantStory(String userEmail);

  /*식물 이야기 상세조회*/
  public PlantStoryDTO detailPlantStory(int boardNum);

  /*식물 이야기 상세 조회에서 조회수 증가*/
  public void updateCnt(int boardNum);

  /*식물 이야기 삭제*/
  public int deletePlantStory(int boardNum);

  /*식물 이야기 수정*/
  public int updatePlantStory(PlantStoryDTO plantStoryDTO);

  //좋아요 선택
  public void insertLike(LikeDTO likeDTO);

  //좋아요 해제
  public void deleteLike(LikeDTO likeDTO);
}
