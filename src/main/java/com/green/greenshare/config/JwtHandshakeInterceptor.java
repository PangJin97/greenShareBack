package com.green.greenshare.config;

import com.green.greenshare.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

@RequiredArgsConstructor
public class JwtHandshakeInterceptor implements HandshakeInterceptor {

  private final JwtUtil jwtUtil;

  @Override
  public boolean beforeHandshake(ServerHttpRequest request,
                                 ServerHttpResponse response,
                                 WebSocketHandler wsHandler,
                                 Map<String, Object> attributes) {
    if (request instanceof ServletServerHttpRequest servletRequest) {
      HttpServletRequest httpRequest = servletRequest.getServletRequest();
      String token = httpRequest.getParameter("token"); // ✅ ?token=Bearer xxx

      if (token != null && token.startsWith("Bearer ")) {
        try {
          String jwt = token.split(" ")[1]; // "Bearer " 이후 실제 토큰 부분
          String userEmail = jwtUtil.getUsername(jwt); // 토큰 디코딩해서 이메일 추출
          attributes.put("userEmail", userEmail); // 세션 attribute에 저장
        } catch (Exception e) {
          e.printStackTrace(); // 문제 생기면 서버 로그에 찍기
        }
      }
    }
    return true; // 계속 Handshake 진행
  }

  @Override
  public void afterHandshake(ServerHttpRequest request,
                             ServerHttpResponse response,
                             WebSocketHandler wsHandler,
                             Exception exception) {
    // 사용 안 함
  }
}
