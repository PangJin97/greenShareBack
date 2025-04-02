package com.green.greenshare.environment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
//2025.04.02 수정
public class EnvironmentDTO {
  private double envId;
  private int temperature;
  private int envId;
  private float temperature;
  private int illuminance;
  private LocalDateTime joinDate;

}
