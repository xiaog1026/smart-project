package jp.co.project.smart.config;

import static jp.co.project.smart.model.Constants.HEADER_STRING;
import static jp.co.project.smart.model.Constants.TOKEN_PREFIX;

import java.io.IOException;
import java.security.SignatureException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader(HEADER_STRING);
		String username = null;
		String authToken = null;

		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"X-Requested-With, Content-Type, Authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
		chain.doFilter(req, res);
		return;
//		if (header != null && header.startsWith(TOKEN_PREFIX)) {
//			authToken = header.replace(TOKEN_PREFIX, "");
//			try {
//			
//
////				username = jwtTokenUtil.getUsernameFromToken(authToken);
//
//			} catch (IllegalArgumentException e) {
//				logger.error("an error occured during getting username from token", e);
//				chain.doFilter(req, res);
////			} catch (ExpiredJwtException e) {
////				logger.warn("the token is expired and not valid anymore", e);
////			} catch (SignatureException e) {
////				logger.error("Authentication Failed. Username or Password not valid.");
//			}
//		} else {
//			logger.warn("couldn't find bearer string, will ignore the header");
//		}
//		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//
//			if (jwtTokenUtil.validateToken(authToken, userDetails)) {
//				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//						userDetails, null, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
//				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
//				logger.info("authenticated user " + username + ", setting security context");
//				SecurityContextHolder.getContext().setAuthentication(authentication);
//			}
//		}
//
//		chain.doFilter(req, res);
	}
}