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
  private final EnvironmentService environmentService;

  @GetMapping("")
  public List<EnvironmentDTO> environmentlist(EnvironmentDTO environmentDTO){
  return  environmentService.environmentlist(environmentDTO);

  }


  @GetMapping("/latest")
  public  EnvironmentDTO lastestData (){
    return environmentService.latestData();
  }
  @GetMapping("/latestHour")
  public  List<EnvironmentDTO> lastestData12 (){
    return environmentService.latestData12();
  }


}
