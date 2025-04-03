package com.green.greenshare.plant;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PlantMapper {

  /*작물 리스트 기본 정보 조회*/
  public List<PlantDTO> getCropStandards();

  /*작물 상세 리스트 정보 조회 */
  public PlantDTO getSelectCropList(String id);



}
