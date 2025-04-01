package com.green.greenshare.farmer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyFarmerServiceImpl implements ReplyFarmerService {
  private final ReplyFarmerMapper replyFarmerMapper;

  @Override
  public List<ReplyFarmersDTO> replySelect(int boardNum) {
    return replyFarmerMapper.replySelect(boardNum);
  }

  @Override
  public void insertReply(ReplyFarmersDTO replyFarmersDTO) {
     replyFarmerMapper.insertReply(replyFarmersDTO);
  }

  @Override
  public void deleteReply(int replyNum) {
    replyFarmerMapper.deleteReply(replyNum);
  }
}
