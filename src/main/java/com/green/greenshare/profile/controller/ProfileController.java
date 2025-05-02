package com.green.greenshare.profile.controller;

import com.green.greenshare.profile.dto.ProfileDTO;
import com.green.greenshare.profile.mapper.ProfileMapper;
import com.green.greenshare.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profiles")
public class ProfileController {

  @Autowired
  ProfileService profileService;
  @Autowired
  ProfileMapper profileMapper;

  @PostMapping("")
  public ResponseEntity<String> insertProfileImage(@RequestBody ProfileDTO profileDTO){
    profileService.insertProfileImage(profileDTO);
    return ResponseEntity.ok("프로필 이미지 저장 성공");
  }

  @GetMapping("")
  public ResponseEntity<ProfileDTO> selectLatestProfile(
      @RequestParam("userEmail") String  userEmail
  ){
    ProfileDTO dto = profileMapper.selectLatestProfile(userEmail);
    return ResponseEntity.ok(dto);
  }
}
