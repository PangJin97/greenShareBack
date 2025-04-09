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
}
