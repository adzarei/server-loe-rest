package adzarei.loe.server.security.authentication.filter;


import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.removeStart;


//Class responsible of extracting the TOKEN from the request headers.
//Reads the AUTHORISATION header value and attempts to extract the TOKEN.
public final class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final String BEARER = "Bearer";

    public TokenAuthenticationFilter(final RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        final String param = ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
                .orElse(request.getParameter("t"));

        final String token = ofNullable(param)
                .map(value -> removeStart(value,BEARER))
                .map(String::trim)
                .orElseThrow(() -> new BadCredentialsException("Bearer Token missing"));
        final Authentication auth = new UsernamePasswordAuthenticationToken(token,token);

        return getAuthenticationManager().authenticate(auth);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }



    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request,response);
    }
}
