package com.todo.zuul.security;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/*************************************************************************************************************
 *
 * purpose:To generate jwtToken and to decode the token
 * 
 * @author sowjanya467
 * @version 1.0
 * @since 10-07-18
 *
 **************************************************************************************************/
@Component("tokens")
public class JwtTokens {
	final static String KEY = "sowjanya";

	/**
	 * purpose: Decoding the token(to get details of user)
	 * 
	 * @param Jwt
	 * @return
	 */
	public Claims parseJwt(String jwt) {
		return Jwts.parser().setSigningKey(KEY).parseClaimsJws(jwt).getBody();

	}

}
