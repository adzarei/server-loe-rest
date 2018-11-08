package adzarei.loe.server.security.authentication.provider;

import adzarei.loe.server.security.authentication.services.UserAuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Optional;

//Class responsible of finding the user by it's authentication TOKEN.
@Component
@AllArgsConstructor
public final class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @NotNull UserAuthenticationService userAuthenticationService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {}

    //TODO: username has to be loginuser.usernam
    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        final Object token = authentication.getCredentials();

        if (token.equals(null))
            throw new AuthenticationCredentialsNotFoundException("Token not present or empty");

        return Optional
                .ofNullable(token)
                .map(String::valueOf)
                .flatMap(userAuthenticationService::findLoginUserByTokenUuid)
                .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with token="+token));
    }
}
