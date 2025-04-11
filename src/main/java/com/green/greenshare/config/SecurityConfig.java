package com.green.greenshare.config;

import com.green.greenshare.jwt.JwtConfirmFilter;
import com.green.greenshare.jwt.JwtUtil;
import com.green.greenshare.jwt.LoginFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@RestController
@RequiredArgsConstructor
@EnableWebSecurity //해당클래스가  Security 설정을 컨트롤할 수 있도록 세팅하는 어노테이션
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {
  private final JwtUtil jwtUtil;

  /*
   * 실제 시큐리티의 인증& 인가에대한 설정 코드를 작성하는 메서드
   * */
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationConfiguration authConfig) throws  Exception{
    // AuthenticationManager : Spring security 에서 실제로 로그인 검증** 을 진행하는 객체
    AuthenticationManager authenticationManager = authConfig.getAuthenticationManager();

    http.cors(Customizer.withDefaults())// 아래설정한 cors 내용을 사용하겠다.
            .csrf(csrf  ->  csrf.disable())
            .formLogin(Form ->Form.disable())
            .httpBasic(basic -> basic.disable())
            .sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            //인증및 인가에대한 설정 부분
            .authorizeHttpRequests(auth ->
                    auth.anyRequest().permitAll()
            ); // auth.anyRequest().permitAll() 이부분만 여기만 컨트롤 하면됨 **********************

    //모든 요청에서 토큰을 검증하는 JwtConfirmFilter 클래스를 SecurityFilterChain에 추가
    //JwtConfirmFilter 클래스는 LoginFilter가 진행되기 전에 실행되도록 설정 함
    http.addFilterBefore(new JwtConfirmFilter(jwtUtil), LoginFilter.class);


    //원래 로그인 요청을 받는 userNamepasswordAuthenticationFilter 대신
    //우리가 커스터마이징한 loginFilter를 사용하도록 필터 교체 !
    http.addFilterAt(new LoginFilter(authenticationManager, jwtUtil), UsernamePasswordAuthenticationFilter.class);



    return http.build();
  }

  //cors설정
  @Bean
  public CorsConfigurationSource corsConfigurationSource(){
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedOrigin("http://localhost:5173"); // 리액트에서 스프링으로 접근허용 메서드
    config.addAllowedHeader("*"); // 모든 헤더 정보 허용
    config.addAllowedMethod("*"); //get,post,delete, put 모든요청 허용

    UrlBasedCorsConfigurationSource source =new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);

    return source;


  }

  //비밀번호 암호화 기능을 제공하는 객체 생성 메서드
  @Bean
  public PasswordEncoder getPassWordEncoder (){
    return new BCryptPasswordEncoder();


  }

}
