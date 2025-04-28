package com.green.greenshare.user.manager;

import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 설명: 현재 온라인(연결된) 사용자 이메일을 관리하는 클래스
 */
@Component
public class OnlineUserManager {

  private final Set<String> onlineUsers = ConcurrentHashMap.newKeySet();

  // 사용자가 접속했을 때 호출
  public void connect(String email) {
    onlineUsers.add(email);
  }

  // 사용자가 접속 종료(로그아웃)했을 때 호출
  public void disconnect(String email) {
    onlineUsers.remove(email);
  }

  // 사용자가 현재 온라인인지 확인
  public boolean isConnected(String email) {
    return onlineUsers.contains(email);
  }

  // 현재 전체 온라인 사용자 목록
  public Set<String> getOnlineUsers() {
    return onlineUsers;
  }
}
