package adzarei.loe.server.security.authentication.services;

import adzarei.loe.server.security.model.ActiveToken;
import adzarei.loe.server.security.model.LoginUser;

import adzarei.loe.server.security.repositories.ActiveTokenRepository;
import adzarei.loe.server.security.services.ActiveTokenService;
import adzarei.loe.server.security.services.LoginUserService;
import lombok.NonNull;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UUIDAuthenticationService implements UserAuthenticationService {

    @NonNull private final LoginUserService userService;
    @NonNull private final ActiveTokenService tokenService;

    public UUIDAuthenticationService(LoginUserService userService, ActiveTokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @Override
    public Optional<String> login(String username, String password) {

        LoginUser userInRepo = userService
                .findLoginUserByUsername(username)
                .orElseThrow( () -> new ResourceNotFoundException("User missing in DB, register the user before login."));

        if (userInRepo.getPassword().equals(password)){
            final String uuid = UUID.randomUUID().toString();

            ActiveToken token = new ActiveToken();
            token.setUuid(uuid);
            userInRepo.addToken(token);

            tokenService.saveToken(token);
            userService.patchLoginUser(userInRepo.getId(),userInRepo);

            return Optional.of(uuid);
        }

        throw new BadCredentialsException("Wrong credentials for user:"+username);
    }



    @Override
    public Optional<LoginUser> findLoginUserByToken(String token) {
        //TODO: Find by Token
        return Optional.empty();
    }

    @Override
    public void logout(LoginUser user) {

    }

    @Override
    public Optional<LoginUser> register(LoginUser user) {
        return userService.saveLoginUser(user);
    }
}
