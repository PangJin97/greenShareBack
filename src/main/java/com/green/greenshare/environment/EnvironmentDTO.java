package com.green.greenshare.environment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class EnvironmentDTO {
  private double envId;
  private int temperature;
  private int illuminance;
  private LocalDateTime joinData;

}
