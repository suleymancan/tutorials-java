package com.example.demojwt.security;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayDeque;

/**
 * Created on June, 2019
 *
 * @author suleymancan
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	static final String SECRET = "EmakinaTalent";

	static final String TOKEN_PREFIX = "Bearer ";

	static final String HEADER_STRING = "Authorization";

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final String header = request.getHeader(HEADER_STRING);

		if (header == null || !header.startsWith(TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}
		final UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(request);

		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		chain.doFilter(request, response);

	}

	UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest httpServletRequest) {
		final String token = httpServletRequest.getHeader(HEADER_STRING);
		if (token != null) {
			final String user = Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody().getSubject();
			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, new ArrayDeque<>());
			}
			return null;
		}
		return null;
	}
}
