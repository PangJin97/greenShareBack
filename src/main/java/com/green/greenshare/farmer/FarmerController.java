package com.green.greenshare.farmer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/farmers")
public class FarmerController {
  private final FarmerService farmerService;


  //목록 조회
  @GetMapping("")
  public List<FarmerDTO> farmerList(){
    return farmerService.farmerList();
  }

  //상세조회
  @GetMapping("/{boardNum}")
  public FarmerDTO selectFarmer(@PathVariable("boardNum") int boardNum) {
    return farmerService.selectFarmer(boardNum);
  }

  //등록
  @PostMapping("")
  public int insertFarmers(@RequestBody FarmerDTO farmerDTO){
  return farmerService.insertFarmers(farmerDTO);
  }

  //수정
  @PutMapping("/{boardNum}")
  public int updateFarmers(@PathVariable("boardNum") int boardNum,@RequestBody FarmerDTO farmerDTO){
  farmerDTO.setBoardNum(boardNum);
  return farmerService.updateFarmers(farmerDTO);
  }

  //삭제
  @DeleteMapping("/{boardNum}")
  public  int deleteFarmers(@PathVariable("boardNum")int boardNum){
  return farmerService.deleteFarmers(boardNum);
  }


}
