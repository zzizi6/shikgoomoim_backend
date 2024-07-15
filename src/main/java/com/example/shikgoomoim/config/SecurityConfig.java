package com.example.shikgoomoim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/**","/swagger-ui/**", "/api-docs/**").permitAll() // 스웨거 UI와 API 문서 경로 예외 처리
                                .anyRequest().authenticated() // 나머지 모든 요청은 인증 필요
                )

                .formLogin().disable() // 기본 로그인 폼 활성화

                .httpBasic(withDefaults()); // 기본 HTTP 기반 인증 사용

        return http.build(); // SecurityFilterChain을 반환
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
