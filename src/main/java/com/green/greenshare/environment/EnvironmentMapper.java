package com.green.greenshare.environment;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnvironmentMapper {

  /*온도 , 조도 최신 값 5개를 받아오는 쿼리 자료형 : 리스트*/
  public List<EnvironmentDTO> environmentlist(EnvironmentDTO environmentDTO);

  /* 온도, 조도 가장 최신값 하나를 받아오눈 쿼리 , 자료형 : EnvironmentDTO*/
  EnvironmentDTO latestData();

  List<EnvironmentDTO> latestData12();
}
