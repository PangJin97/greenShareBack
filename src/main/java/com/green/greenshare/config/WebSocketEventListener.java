package com.green.greenshare.config;

import com.green.greenshare.user.manager.OnlineUserManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketEventListener {

  private final OnlineUserManager onlineUserManager;

  @EventListener
  public void handleWebSocketConnectListener(SessionConnectEvent event) {
    StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
    String userEmail = accessor.getUser() != null ? accessor.getUser().getName() : null;
    if (userEmail != null) {
      onlineUserManager.connect(userEmail);
      log.info("✅ 웹소켓 연결 성공: {}", userEmail);
    }
  }

  @EventListener
  public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
    StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
    String userEmail = accessor.getUser() != null ? accessor.getUser().getName() : null;
    if (userEmail != null) {
      onlineUserManager.disconnect(userEmail);
      log.info("❌ 웹소켓 연결 종료: {}", userEmail);
    }
  }
}
