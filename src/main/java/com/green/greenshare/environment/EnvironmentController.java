package com.green.greenshare.environment;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/environment")
public class EnvironmentController {
  private final EnvironmentMapper environmentMapper;

  @GetMapping("")
  public List<EnvironmentDTO> environmentlist(EnvironmentDTO environmentDTO){
  return  environmentMapper.environmentlist(environmentDTO);

  }

}
