package com.green.greenshare.plant;

import java.util.List;

public interface PlantService {

  /*기본작물 조회*/
  public List<PlantDTO> getCropStandards();

  /*작물 상세 리스트 정보 조회 */
  public PlantDTO getSelectCropList(String id);

}
