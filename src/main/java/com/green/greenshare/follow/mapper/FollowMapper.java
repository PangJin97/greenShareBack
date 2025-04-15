package com.green.greenshare.follow.mapper;

import com.green.greenshare.follow.dto.FollowDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FollowMapper {



  // 팔로우 등록 (INSERT)
  int insertFollow(FollowDTO followDTO);


  // 내가 팔로우한 사람 목록 조회
  List<FollowDTO> selectFollowingList(String fromUserEmail);

  //팔로우 취소 쿼리
  int unfollow(@Param("fromUserEmail") String fromUserEmail,
               @Param("toUserEmail") String toUserEmail);





}
