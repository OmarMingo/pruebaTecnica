package com.pruebaTecnica.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.pruebaTecnica.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class LoginServiceImpl implements LoginService{

	@Override
	public String getToken(User user){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("USER");
        return "Bearer " + Jwts.builder().setId(String.valueOf(user.getId())).setSubject(user.getEmail())
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(getSignInKey()).compact();
    }

    private Key getSignInKey() {
        String secretKey = "T21hckFkcmlhblBlcmV6TWluZ28=";
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
