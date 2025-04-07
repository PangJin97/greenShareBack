package com.green.greenshare.plant;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/*데이터 베이스에선 float이지만 자바는 double로*/
public class PlantDTO {
  //각 작물의 고유 id
  private int id;
  //각 작물의 이름
  private String crop;
  //작물의 적정온도
  private double tempMin;
  private double tempMax;
  //작물의 적정 습도
  private double humidMin;
  private double humidMax;
  //작물의 적정 토양 수분
  private double soilMin;
  private double soilMax;
  //작물의 적정 조도(LUX값과 ADC변환값)
  private int luxMin;
  private int luxMax;
  private int adcMin;
  private int adcMax;
  private String engName;
  //이미지 파일
  private String imgName;
  //작물의 설명
  private String description;
}
