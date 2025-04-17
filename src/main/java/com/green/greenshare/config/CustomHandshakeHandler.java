package com.green.greenshare.config;

import com.green.greenshare.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class CustomHandshakeHandler extends DefaultHandshakeHandler {
  private final JwtUtil jwtUtil;

  @Override
  protected Principal determineUser(
          ServerHttpRequest request,
          WebSocketHandler wsHandler,
          Map<String, Object> attributes
  ) {
    String token = (String) attributes.get("token");
    String email = jwtUtil.getUsername(token.split(" ")[1]); // JWT 디코딩해서 사용자 이메일 추출
    System.out.println("####" + email);
    return new UsernamePasswordAuthenticationToken(email, null, List.of());
  }
}