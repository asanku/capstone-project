package com.SpringSecurity.LoginRegist.JWT.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {

    //@Value("c9dcb68cf06ce407819f4222fed486f4c8ae9ec7e92865aed2ae642a8e62be7fe5a2bf1963362875bc6041357760cda2dcd8c9daccf92c7236adbb0e06c7e62e")
    private final static String  SECRET_KEY = "c9dcb68cf06ce407819f4222fed486f4c8ae9ec7e92865aed2ae642a8e62be7fe5a2bf1963362875bc6041357760cda2dcd8c9daccf92c7236adbb0e06c7e62e";

    //@Value("86400000")
    private final static long jwtExpiration = 86400000;

    //@Value("604800000")
    private final static long refreshExpiration = 604800000;

    //private final long clockSkewInMs = 30000; // 5 minutes

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {

        return buildToken(extraClaims, userDetails, jwtExpiration);

    }

    public String generateRefreshToken(UserDetails userDetails) {

        return buildToken(new HashMap<>(), userDetails, refreshExpiration);

    }

    private String buildToken(Map<String, Object> extraClaims,
                              UserDetails userDetails,
                              long expiration) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInkey(), SignatureAlgorithm.HS512)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> ClaimsResolver) {
        final Claims claims = extractAllClaims(token);
        return ClaimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {

        return Jwts
                .parser()
                .setSigningKey(getSignInkey())
               // //.setAllowedClockSkewSeconds(clockSkewInMs / 1000)
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !TokenExpired(token));
    }

    private boolean TokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Key getSignInkey() {
        byte keybytes[] = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keybytes);
    }

}
