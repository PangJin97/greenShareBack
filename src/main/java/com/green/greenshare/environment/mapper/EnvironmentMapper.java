package com.green.greenshare.environment.mapper;

import com.green.greenshare.environment.dto.EnvironmentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EnvironmentMapper {

  /*온도 , 조도 최신 값 5개를 받아오는 쿼리 자료형 : 리스트*/
  public List<EnvironmentDTO> environmentlist(EnvironmentDTO environmentDTO);

  /* 온도, 조도 가장 최신값 하나를 받아오눈 쿼리 , 자료형 : EnvironmentDTO*/
  EnvironmentDTO latestData();

  List<EnvironmentDTO> latestData12();

  List<EnvironmentDTO> selectTemperatureByInterval(
      @Param("intervalValue") int intervalValue,
      @Param("groupFormat") String groupFormat
  );

  List<EnvironmentDTO> selectIlluminanceByInterval(
      @Param("intervalValue") int intervalValue,
      @Param("groupFormat") String groupFormat
  );

  List<EnvironmentDTO> selectSoilByInterval(
      @Param("intervalValue") int intervalValue,
      @Param("groupFormat") String groupFormat
  );
  List<EnvironmentDTO> selectHumidityByInterval(
      @Param("intervalValue") int intervalValue,
      @Param("groupFormat") String groupFormat
  );


}
