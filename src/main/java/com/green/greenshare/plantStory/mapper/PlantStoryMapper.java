package com.green.greenshare.plantStory.mapper;

import com.green.greenshare.plantStory.dto.LikeDTO;
import com.green.greenshare.plantStory.dto.PlantStoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlantStoryMapper {
  // 식물 이야기 등록
  public int insertPlantStory(PlantStoryDTO plantStoryDTO);

  /*식물 이야기 조회하기*/
  public List<PlantStoryDTO> getPlantStory(String userEmail);

  // 상세 조회
  public PlantStoryDTO detailPlantStory(int boardNum);

  // 조회수 증가
  public void updateCnt(int boardNum);

  // 삭제
  public int deletePlantStory(int boardNum);

  // 수정
  public int updatePlantStory(PlantStoryDTO plantStoryDTO);

  //좋아요 선택
  public void insertLike(LikeDTO likeDTO);

  //좋아요 해제
  public void deleteLike(LikeDTO likeDTO);

  // 작성자 이메일 조회 (권한 체크용)
  public String getWriterEmail(int boardNum);

  // 앱에서 로그인 한 사람의 글만 조회하기
  public List<PlantStoryDTO> selectMyPost(String userEmail);

  // 앱에서 홈 화면에 인기 게시글 띄우기(좋아요순)
  public List<PlantStoryDTO> getPopularPosts(String userEmail);


  //test 용
  public List<PlantStoryDTO> selectBoard(PlantStoryDTO plantStoryDTO);
}
