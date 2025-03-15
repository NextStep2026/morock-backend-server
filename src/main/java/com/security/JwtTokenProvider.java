package com.security;

import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String secretKey;

    private final long validityInMilliseconds = 3600000; // 1시간

    public String createToken(Long userId) {
        Claims claims = Jwts.claims().setSubject(String.valueOf(userId));
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + validityInMilliseconds))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Long getUserIdFromToken(String token) {
        return Long.valueOf(Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject());
    }
    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
//            log.error("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
//            log.error("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
//            log.error("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
//            log.error("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }


}
