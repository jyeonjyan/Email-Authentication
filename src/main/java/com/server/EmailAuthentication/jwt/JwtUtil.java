//package com.server.EmailAuthentication.jwt;
//
//import com.server.EmailAuthentication.domain.User;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.nio.charset.StandardCharsets;
//import java.security.Key;
//import java.util.Date;
//
//@Component
//public class JwtUtil {
//    public final static long TOKEN_VALIDATION_SECOND = 1000L * 10;
//    public final static long REFRESH_TOKEN_VALIDATION_SECOND = 1000L * 60 * 24 * 2;
//
//    final static public String ACCESS_TOKEN_NAME = "accessToken";
//    final static public String REFRESH_TOKEN_NAME = "refreshToken";
//
//    @Value("${spring.jwt.secret}")
//    private String SECRET_KEY;
//
//    private Key getSigningKey(String secretKey) {
//        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//    // 토큰 유효성 검사 후, payload 값을 가져온다.
//    public Claims extractAllClaims(String token) throws ExpiredJwtException {
//        return Jwts.parserBuilder()
//                .setSigningKey(getSigningKey(SECRET_KEY))
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
//    // 추출한 Payload 로부터 userName을 가져온다.
//    public String getUsername(String token) {
//        return extractAllClaims(token).get("username", String.class);
//    }
//    // 토큰이 만료됐는지 확인.
//    public Boolean isTokenExpired(String token) {
//        final Date expiration = extractAllClaims(token).getExpiration();
//        return expiration.before(new Date());
//    }
//    // Access/Refresh Token을 생성.
//    public String generateToken(User user) {
//        return doGenerateToken(user.getUserName(), TOKEN_VALIDATION_SECOND);
//    }
//
//    public String generateRefreshToken(User user) {
//        return doGenerateToken(user.getUserName(), REFRESH_TOKEN_VALIDATION_SECOND);
//    }
//    // 토큰을 생성, 페이로드에 담길 값은 username.
//    public String doGenerateToken(String username, long expireTime) {
//
//        Claims claims = Jwts.claims();
//        claims.put("username", username);
//
//        String jwt = Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + expireTime))
//                .signWith(getSigningKey(SECRET_KEY), SignatureAlgorithm.HS256)
//                .compact();
//
//        return jwt;
//    }
//
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        final String username = getUsername(token);
//
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//
//}
