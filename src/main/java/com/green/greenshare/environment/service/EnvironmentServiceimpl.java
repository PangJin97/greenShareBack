package com.green.greenshare.environment.service;

import com.green.greenshare.environment.dto.EnvironmentDTO;
import com.green.greenshare.environment.mapper.EnvironmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EnvironmentServiceimpl implements EnvironmentService {
  public final EnvironmentMapper environmentMapper;


  @Override
  public List<EnvironmentDTO> environmentlist(EnvironmentDTO environmentDTO) {
    return environmentMapper.environmentlist(environmentDTO);
  }

  @Override
  public List<EnvironmentDTO> latestData12() {
    return environmentMapper.latestData12();
  }

  @Override
  public EnvironmentDTO latestData() {
    return environmentMapper.latestData();
  }

  @Override
  public List<EnvironmentDTO> selectTemperatureByInterval(String interval) {
    int intervalValue;
    String groupFormat;

    switch (interval) {
      case "1h":
        intervalValue = 1;
        groupFormat = "%Y-%m-%d %H:%i"; // 분 단위
        break;
      case "6h":
        intervalValue = 6;
        groupFormat = "%Y-%m-%d %H";   // 시간 단위
        break;
      case "12h":
        intervalValue = 12;
        groupFormat = "%Y-%m-%d %H";   // 시간 단위
        break;
      default:
        throw new IllegalArgumentException("Invalid interval: " + interval);
    }

    return environmentMapper.selectTemperatureByInterval(intervalValue, groupFormat);

  }

  @Override
  public List<EnvironmentDTO> selectIlluminanceByInterval(String interval) {
    int intervalValue;
    String groupFormat;

    switch (interval) {
      case "1h":
        intervalValue = 1;
        groupFormat = "%Y-%m-%d %H:%i"; // 분 단위
        break;
      case "6h":
        intervalValue = 6;
        groupFormat = "%Y-%m-%d %H";   // 시간 단위
        break;
      case "12h":
        intervalValue = 12;
        groupFormat = "%Y-%m-%d %H";   // 시간 단위
        break;
      default:
        throw new IllegalArgumentException("Invalid interval: " + interval);
    }
    return environmentMapper.selectIlluminanceByInterval(intervalValue, groupFormat);
  }

  @Override
  public List<EnvironmentDTO> selectSoilByInterval(String interval) {
    int intervalValue;
    String groupFormat;

    switch (interval) {
      case "1h":
        intervalValue = 1;
        groupFormat = "%Y-%m-%d %H:%i"; // 분 단위
        break;
      case "6h":
        intervalValue = 6;
        groupFormat = "%Y-%m-%d %H";   // 시간 단위
        break;
      case "12h":
        intervalValue = 12;
        groupFormat = "%Y-%m-%d %H";   // 시간 단위
        break;
      default:
        throw new IllegalArgumentException("Invalid interval: " + interval);
    }
    return environmentMapper.selectSoilByInterval(intervalValue, groupFormat);
  }

  @Override
  public List<EnvironmentDTO> selectHumidityByInterval(String interval) {
    int intervalValue;
    String groupFormat;

    switch (interval) {
      case "1h":
        intervalValue = 1;
        groupFormat = "%Y-%m-%d %H:%i"; // 분 단위
        break;
      case "6h":
        intervalValue = 6;
        groupFormat = "%Y-%m-%d %H";   // 시간 단위
        break;
      case "12h":
        intervalValue = 12;
        groupFormat = "%Y-%m-%d %H";   // 시간 단위
        break;
      default:
        throw new IllegalArgumentException("Invalid interval: " + interval);
    }
    return environmentMapper.selectHumidityByInterval(intervalValue, groupFormat);
  }
}

