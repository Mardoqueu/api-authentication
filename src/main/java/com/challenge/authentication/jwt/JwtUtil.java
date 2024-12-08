package com.challenge.authentication.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * JwtUtil is a utility class for handling JSON Web Token (JWT) operations such as token generation,
 * extraction, and validation. It is used to facilitate authentication and authorization processes
 * by creating tokens that can securely transmit user identities.
 *
 * This component retrieves the secret key from application properties to sign and verify JWTs.
 *
 * Methods:
 * - generateToken: Generates a JWT for a given username with a set expiration.
 * - extractUsername: Extracts the username from the JWT token.
 * - validateToken: Validates the JWT token against user details and checks for expiration.
 *
 * The token is signed using the HS256 algorithm and remains valid for a specific duration
 * as defined in the generateToken method.
 */
@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2)) // Token valid for 2 hours
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Boolean isTokenExpired(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }
}

