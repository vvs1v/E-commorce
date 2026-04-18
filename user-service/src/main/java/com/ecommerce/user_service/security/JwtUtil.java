package com.ecommerce.user_service.security;

//public class JwtUtil {
//}
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Use SecretKey type for the modern API
    private final SecretKey key = Keys.hmacShaKeyFor(
            "your-256-bit-secret-string-at-least-32-characters-long".getBytes(StandardCharsets.UTF_8)
    );

    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username) // setSubject -> subject
                .issuedAt(new Date()) // setIssuedAt -> issuedAt
                .expiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(key) // Algorithm is now inferred from the Key type
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()           // parserBuilder() -> parser()
                .verifyWith(key)       // setSigningKey() -> verifyWith()
                .build()
                .parseSignedClaims(token) // parseClaimsJws() -> parseSignedClaims()
                .getPayload()          // getBody() -> getPayload()
                .getSubject();
    }

//    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
//                .signWith(key)
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(key)
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
}
