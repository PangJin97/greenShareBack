package com.green.greenshare.environment;

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
