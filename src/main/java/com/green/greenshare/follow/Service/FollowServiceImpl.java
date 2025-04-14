package com.green.greenshare.follow.Service;

import com.green.greenshare.follow.dto.FollowDTO;
import com.green.greenshare.follow.mapper.FollowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FollowServiceImpl implements FollowService {
  private final FollowMapper followMapper;


  //내가팔로우한 목록 조회
  @Override
  public List<FollowDTO> selectFollowingList(String fromUserEmail) {
    return followMapper.selectFollowingList(fromUserEmail);
  }

  @Override
  public int insertFollow(FollowDTO followDTO) {
    return followMapper.insertFollow(followDTO);
  }

  @Override
  public int unfollow(String fromUserEmail, String toUserEmail) {
    return followMapper.unfollow(fromUserEmail, toUserEmail);
  }


}
