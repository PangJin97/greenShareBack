package com.green.greenshare.environment;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EnvironmentMapper {

  public List<EnvironmentDTO> environmentlist(EnvironmentDTO environmentDTO);

}
