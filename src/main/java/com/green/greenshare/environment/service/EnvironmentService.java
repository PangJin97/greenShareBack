package com.green.greenshare.environment.service;

import com.green.greenshare.environment.dto.EnvironmentDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnvironmentService {

  public List<EnvironmentDTO> environmentlist(EnvironmentDTO environmentDTO);

  EnvironmentDTO latestData();

  List<EnvironmentDTO> latestData12();

  List<EnvironmentDTO> selectTemperatureByInterval(String interval
  );

  List<EnvironmentDTO> selectIlluminanceByInterval(String interval);

  List<EnvironmentDTO> selectSoilByInterval(String interval);

  List<EnvironmentDTO> selectHumidityByInterval(String interval);
}
