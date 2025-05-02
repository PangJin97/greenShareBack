package com.green.greenshare.profile.mapper;

import com.green.greenshare.profile.dto.ProfileDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProfileMapper {
  /*프로필 이미지 등록*/
  void insertProfileImage(ProfileDTO profileDTO);
  ProfileDTO selectLatestProfile(@Param("userEmail") String  userEmail);
}
