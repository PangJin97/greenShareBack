package com.green.greenshare.profile.service;

import com.green.greenshare.profile.dto.ProfileDTO;
import com.green.greenshare.profile.mapper.ProfileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService{
  final private ProfileMapper profileMapper;

  @Override
  public void insertProfileImage(ProfileDTO profileDTO) {
    profileMapper.insertProfileImage(profileDTO);
  }

}
