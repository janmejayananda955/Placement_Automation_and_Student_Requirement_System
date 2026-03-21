package com.college.project.PlacementAutomationandStudentRequirementSystem.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Component
public class AuthUtil {

    @Value("${jwt.secretKey}")
    private String jwtSecretKey;

    //convert to key
    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccessToken(CostumeUserDetails costumeUserDetails) {
        return Jwts.builder()
                .subject(costumeUserDetails.getUsername())
//                .claim("userId",costumeUserDetails.getUserId().toString())  // for single key-value pair
                .claims(
                        Map.of(
                                "userId",costumeUserDetails.getUserId().toString()
                        )
                )
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000*60*10*10))
                .signWith(getSecretKey())
                .compact();
    }

    public String getUserFromToken(String jwtToken) {
        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(jwtToken)
                .getPayload();
        return claims.getSubject();
    }

    public boolean isTokenValid(String token, CostumeUserDetails userDetails) {
        final String username = getUserFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();
        return expiration.before(new Date());
    }
}
