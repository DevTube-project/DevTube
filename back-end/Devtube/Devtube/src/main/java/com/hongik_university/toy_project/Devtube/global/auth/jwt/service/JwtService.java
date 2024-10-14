package com.hongik_university.toy_project.Devtube.global.auth.jwt.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hongik_university.toy_project.Devtube.domain.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Getter
@Slf4j
public class JwtService {
    // yaml 파일에 설정해놓은 비밀키
    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("${jwt.access.expiration}")
    private Long accessTokenExpirationPeriod;

    @Value("${jwt.refresh.expiration}")
    private Long refreshTokenExpirationPeriod;

    @Value("${jwt.access.header}")
    private String accessHeader;

    @Value("${jwt.refresh.header}")
    private String refreshHeader;

    /*
     * JWT의 Subject와 Claim으로 userId 사용 -> 클레임의 name을 "userId"로 설정
     * JWT의 헤더에 들어오는 값 : 'Authorization(Key) = Bearer {토큰} (Value)' 형식
     */
    private static final String ACCESS_TOKEN_SUBJECT = "AccessToken";
    private static final String REFRESH_TOKEN_SUBJECT = "RefreshToken";
    private static final String USER_ID_CLAIM = "userId";
    private static final String BEARER = "Bearer ";

    private final UserRepository userRepository;

    /*
     * AccessToken 생성 메소드
     */
    public String createAccessToken(String userId) {
        // 현재 날짜
        Date now = new Date();

        return JWT.create() // JWT 토큰 반환하는 빌더 반환
                .withSubject(ACCESS_TOKEN_SUBJECT) //JWT의 Subject 즉 토큰 제목
                .withExpiresAt(new Date(now.getTime() + accessTokenExpirationPeriod)) // 토큰 만료 시간 -> 현재 날짜 + 만료기한
                .withClaim(USER_ID_CLAIM, userId) // 클레임을 추가적으로 더 사용할 것이라면 .withClaim(클래임 이름, 클래임 값) 으로 설정하면 된다
                .sign(Algorithm.HMAC512(secretKey)); // HMAC512 알고리즘 사용
    }

    /*
     * RefreshToken 생성 메소드
     */
    public String createRefreshToken() {
        // 현재 날짜
        Date now = new Date();

        // refresh 토큰은 Claim을 따로 넣어주지 않음
        return JWT.create()
                .withSubject(REFRESH_TOKEN_SUBJECT)
                .withExpiresAt(new Date(now.getTime() + refreshTokenExpirationPeriod))
                .sign(Algorithm.HMAC512(secretKey));
    }

    /*
     * AccessToken 헤더에 실어서 보내기
     */
    public void sendAccessToken(HttpServletResponse response, String accessToken) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader(accessHeader, accessToken);
        log.info("재발급된 Access Token : {}", accessToken);
    }

    /*
     * AccessToken + RefreshToken 헤더에 실어서 보내기
     */
    public void sendAccessAndRefreshToken(HttpServletResponse response, String accessToken, String refreshToken) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader(accessHeader, accessToken); // Header 이름 , Header value
        response.setHeader(refreshHeader, refreshToken);
        log.info("Access Token, Refresh Token 헤더 설정 완료");
    }

    /*
     * 헤더에서 RefreshToken 추출
     * Bearer 제외하고 순수 토큰 가져옴
     */
    public Optional<String> extractRefreshToken(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(refreshHeader))
                .filter(refreshToken -> refreshToken.startsWith(BEARER))
                .map(refreshToken -> refreshToken.replace(BEARER, "")); // Bearer 삭제
    }

    /*
     * 헤더에서 AccessToken 추출
     * Bearer 제외하고 순수 토큰 가져옴
     */
    public Optional<String> extractAccessToken(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(accessHeader))
                .filter(refreshToken -> refreshToken.startsWith(BEARER))
                .map(refreshToken -> refreshToken.replace(BEARER, ""));
    }

    /* AccessToken 에서 userId 추출
     * 추출 전에 JWT.require()로 검증기 생성
     * verify로 AccessToken 검증 후
     * 유효하다면 getClaim() 으로 추출
     * 유요하지 않다면 빈 Optional 객체 반환
     */
    public Optional<String> extractUserId(String accessToken) {
        try {
            // 토큰 유효성 검사하는데 사용할 알고리즘이 있는 JWT verifier builder 반환
            return Optional.ofNullable(JWT.require(Algorithm.HMAC512(secretKey))
                    .build() // 반환된 빌더로 JWT verifier 생성
                    .verify(accessToken) // accessToken을 검증하고 유효하지 않다면 예외 발생
                    .getClaim(USER_ID_CLAIM)
                    .asString());
        } catch (Exception e) {
            log.error("엑세스 토큰이 유효하지 않습니다");
            return Optional.empty();
        }
    }

    /*
     * RefreshToken DB 저장 (업데이트)
     */
    public void updateRefreshToken(String userId,String refreshToken){
        userRepository.findByUserId(userId)
                .ifPresentOrElse(
                        user -> user.updateRefreshToken(refreshToken),
                        () -> new Exception("일치하는 회원이 없습니다")
                );
    }

    public boolean isTokenValid(String token){
        try {
            JWT.require(Algorithm.HMAC512(secretKey))
                    .build()
                    .verify(token);
            return true;
        }
        catch (Exception e){
            log.error("유효하지 않은 토큰 입니다. {}", e.getMessage());
            return false;
        }
    }
}
