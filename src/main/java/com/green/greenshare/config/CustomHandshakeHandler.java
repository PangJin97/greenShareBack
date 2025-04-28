package com.green.greenshare.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

public class CustomHandshakeHandler extends DefaultHandshakeHandler {

  @Override
  protected Principal determineUser(ServerHttpRequest request,
                                    WebSocketHandler wsHandler,
                                    Map<String, Object> attributes) {
    String userEmail = (String) attributes.get("userEmail"); // ✅ 여기서 가져옴
    System.out.println("✅ HandshakeHandler userEmail = " + userEmail); // 확인용
    if (userEmail != null) {
      return new StompPrincipal(userEmail); // Principal 세팅!
    }
    return null;
  }
}
