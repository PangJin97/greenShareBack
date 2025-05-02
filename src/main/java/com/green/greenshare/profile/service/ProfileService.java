package com.green.greenshare.profile.service;

import com.green.greenshare.profile.dto.ProfileDTO;

public interface ProfileService {
  /*프로필 이미지 등록 서비스*/
  void insertProfileImage(ProfileDTO profileDTO);
}
