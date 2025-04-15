package com.green.greenshare.follow.Service;


import com.green.greenshare.follow.dto.FollowDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


//내가 팔로우한 목록조회
public interface FollowService {

  List<FollowDTO> selectFollowingList(String fromUserEmail);


  // 팔로우 등록 (INSERT)
  int insertFollow(FollowDTO followDTO);

  //팔로우 취소 쿼리
  int unfollow(@Param("fromUserEmail") String fromUserEmail,
               @Param("toUserEmail") String toUserEmail);

}
