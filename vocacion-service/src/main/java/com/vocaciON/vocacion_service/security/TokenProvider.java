package com.vocaciON.vocacion_service.security;

import com.vocaciON.vocacion_service.model.entity.Usuario;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.management.relation.RoleInfoNotFoundException;
import javax.management.relation.RoleNotFoundException;
import java.security.Key;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component

public class TokenProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.validity-in-seconds}")
    private Long jwtValidityInSeconds;

    private Key key;
    private JwtParser jwtParser;

    @PostConstruct
    public void init() {

        key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));

        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
    }

    public String createAccessToken(Authentication authentication) {
        String correo = authentication.getName();

        String role = authentication
                .getAuthorities()
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontró ningún rol para el usuario"))
                .getAuthority();

        return Jwts
                .builder()
                .setSubject(correo)
                .claim("role", role)
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(new Date(System.currentTimeMillis() + jwtValidityInSeconds*1000))
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = jwtParser.parseClaimsJws(token).getBody();

        String role = claims.get("role").toString();

        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(role));

        User principal = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String token) {

        try {
            jwtParser.parseClaimsJws(token);
            return true;
        }catch (JwtException e) {
            return false;
        }

    }
    

}
