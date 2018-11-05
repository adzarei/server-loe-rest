package adzarei.loe.server.security.authentication.services;

import adzarei.loe.server.security.model.LoginUser;

import adzarei.loe.server.security.services.LoginUserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UUIDAuthenticationService implements UserAuthenticationService {

    //@NonNull
    //LoginUserService userService;

    @Override
    public Optional<String> login(String username, String password) {
        final String uuid = UUID.randomUUID().toString();
        final LoginUser user = LoginUser
                .builder()
                //.id(uuid)
                .username(username)
                .password(password)
                .build();

        //userService.saveLoginUser(user);
        return Optional.of(uuid);
    }

    @Override
    public Optional<LoginUser> findLoginUserByToken(String token) {
        //TODO: Find by Token
        return Optional.empty();
    }

    @Override
    public void logout(LoginUser user) {

    }
}
