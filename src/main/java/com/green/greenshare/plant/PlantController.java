package com.green.greenshare.plant;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plants")
@RequiredArgsConstructor
public class PlantController {

  private final PlantService plantService;

  @GetMapping("")
  public List<PlantDTO> getCropStandards(){
    return plantService.getCropStandards();
  }
}
