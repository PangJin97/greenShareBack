package com.green.greenshare.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.util.Map;

public class JwtHandshakeInterceptor implements HandshakeInterceptor {
  @Override
  public boolean beforeHandshake(
          ServerHttpRequest request,
          ServerHttpResponse response,
          WebSocketHandler wsHandler,
          Map<String, Object> attributes
  ) {
    if (request instanceof ServletServerHttpRequest servletRequest) {
      HttpServletRequest httpRequest = servletRequest.getServletRequest();
      String token = httpRequest.getParameter("token");
      System.out.println("1111111111111" + token);
      if (token != null) {
        attributes.put("token", token);
      }
    }
    return true;
  }

  @Override
  public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                             WebSocketHandler wsHandler, Exception exception) {
  }
}